package com.arjuncodes.studentsystem.service.impl;

import com.arjuncodes.studentsystem.model.Booking;
import com.arjuncodes.studentsystem.model.Hostel;
import com.arjuncodes.studentsystem.repository.BookingRepository;
import com.arjuncodes.studentsystem.service.BookingService;
import com.arjuncodes.studentsystem.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private HostelService hostelService;

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(int id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBooking(int id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public List<Booking> findByUserId(int userId) {
        return bookingRepository.findByUserId(userId);
    }

    @Override
    public Map<String, Object> getBookingInfoByUserId(int userId) {
        List<Booking> bookings = bookingRepository.findByUserId(userId);
        if (bookings == null || bookings.isEmpty()) {
            return null;
        }

        Map<String, Object> response = new HashMap<>();
        for (Booking booking : bookings) {
            Hostel hostel = hostelService.getHostelById(booking.getHostelId());
            if (hostel != null) {
                Map<String, Object> bookingInfo = new HashMap<>();
                bookingInfo.put("hostelId", booking.getHostelId());
                bookingInfo.put("hostelName", hostel.getName());
                bookingInfo.put("totalPrice", booking.getTotalPrice());
                bookingInfo.put("roomType", booking.getRoomType());
                response.put("bookingId_" + booking.getId(), bookingInfo);
            }
        }
        return response;
    }

}
