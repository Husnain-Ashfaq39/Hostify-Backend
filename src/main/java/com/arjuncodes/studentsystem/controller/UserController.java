package com.arjuncodes.studentsystem.controller;

import com.arjuncodes.studentsystem.model.*;
import com.arjuncodes.studentsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private WishlistService wishlistService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private HostelService hostelService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/add")
    public String add(@RequestBody User user){
        userService.saveUser(user);
        return "New User is added";
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User loginUser) {
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            if (user.getEmail().equals(loginUser.getEmail()) &&
                    user.getPassword().equals(loginUser.getPassword())) {
                return ResponseEntity.ok(user);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        else {
            user.setFirstname(updatedUser.getFirstname());
            user.setLastname(updatedUser.getLastname());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            userService.saveUser(user);
            return ResponseEntity.ok(user);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getAll")
    public List<User> list(){
        return userService.getAllUsers();
    }

    @PostMapping("/{userId}/wishlist/add")
    public ResponseEntity<String> addFavourite(@PathVariable int userId, @RequestParam int hostelId) {
        Wishlist wishlist = new Wishlist();
        wishlist.setUserId(userId);
        wishlist.setHostelId(hostelId);
        wishlistService.saveWishlist(wishlist);
        return ResponseEntity.ok("Favourite added");
    }

    @DeleteMapping("/{userId}/wishlist/remove")
    public ResponseEntity<String> removeFavourite(@PathVariable int userId, @RequestParam int hostelId) {
        Wishlist wishlist = wishlistService.findByUserIdAndHostelId(userId, hostelId);
        if (wishlist != null) {
            wishlistService.deleteWishlist(wishlist);
            return ResponseEntity.ok("Favourite removed");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Favourite not found");
    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, Boolean>> getFavoriteStatus(@RequestParam int userId, @RequestParam int hostelId) {
        Wishlist wishlist = wishlistService.findByUserIdAndHostelId(userId, hostelId);
        boolean isFavorite = (wishlist != null);
        Map<String, Boolean> response = new HashMap<>();
        response.put("isFavorite", isFavorite);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{userId}/booking/add")
    public ResponseEntity<String> addBooking(@PathVariable int userId, @RequestParam int hostelId, @RequestParam String roomType, @RequestParam double totalPrice) {
        Booking booking = new Booking();
        booking.setUserId(userId);
        booking.setHostelId(hostelId);
        booking.setRoomType(roomType);
        booking.setTotalPrice(totalPrice);
        bookingService.saveBooking(booking);
        return ResponseEntity.ok("Booking added");
    }

    @GetMapping("/{userId}/booking/info")
    public ResponseEntity<Map<String, Object>> getBookingInfo(@PathVariable int userId) {
        Map<String, Object> response = bookingService.getBookingInfoByUserId(userId);
        if (response == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{userId}/review/add")
    public ResponseEntity<String> addReview(@PathVariable int userId, @RequestParam int hostelId, @RequestParam String message) {
        Review review = new Review();
        review.setUserId(userId);
        review.setHostelId(hostelId);
        review.setMessage(message);
        reviewService.saveReview(review);
        return ResponseEntity.ok("Review added");
    }

    @PostMapping("/{userId}/transaction/add")
    public ResponseEntity<String> addTransaction(@PathVariable int userId, @RequestParam int hostelId, @RequestParam double amount, @RequestParam String cardNo) {
        Transaction transaction = new Transaction();
        transaction.setUserid(userId);
        transaction.setHosteid(hostelId);
        transaction.setAmount(amount);
        transaction.setCardno(cardNo);
        transactionService.saveTransaction(transaction);
        return ResponseEntity.ok("Transaction added");
    }
    @GetMapping("/reviews/{hostelId}")
    public ResponseEntity<List<Map<String, String>>> getReviewsByHostelId(@PathVariable int hostelId) {
        List<Review> reviews = reviewService.findByHostelId(hostelId);
        if (reviews.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        List<Map<String, String>> response = new ArrayList<>();
        for (Review review : reviews) {
            User user = userService.getUserById(review.getUserId());
            Map<String, String> reviewDetails = new HashMap<>();
            reviewDetails.put("username", user.getFirstname() + " " + user.getLastname());
            reviewDetails.put("message", review.getMessage());
            response.add(reviewDetails);
        }
        return ResponseEntity.ok(response);
    }
}
