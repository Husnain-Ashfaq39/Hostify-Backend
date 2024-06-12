package com.arjuncodes.studentsystem.controller;

import com.arjuncodes.studentsystem.model.Owner;
import com.arjuncodes.studentsystem.model.User;
import com.arjuncodes.studentsystem.service.OwnerService;
import com.arjuncodes.studentsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
@CrossOrigin
public class OwnerController {
    @Autowired
    private OwnerService userService;

    @PostMapping("/add")
    public String add(@RequestBody Owner owner){
        userService.saveUser(owner);
        return "New Owner is added";
    }
    @PostMapping("/login")
    public ResponseEntity<Owner> login(@RequestBody Owner loginUser) {
        List<Owner> owners = userService.getAllUsers();
        System.out.println(loginUser.getEmail());
        for (Owner owner : owners) {
            if (owner.getEmail().equals(loginUser.getEmail()) &&
                    owner.getPassword().equals(loginUser.getPassword())) {
                System.out.println(owner.getId());
                return ResponseEntity.ok(owner);  // Return the found owner object
            }
        }

        // If no matching user found, return 401 Unauthorized
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }



    @GetMapping("/getAll")
    public List<Owner> list(){
        return userService.getAllUsers();
    }
}
