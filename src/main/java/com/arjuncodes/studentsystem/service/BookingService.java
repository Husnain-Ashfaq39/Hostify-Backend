package com.arjuncodes.studentsystem.service;

import com.arjuncodes.studentsystem.model.Booking;

import java.util.List;
import java.util.Map;

public interface BookingService {
    Booking saveBooking(Booking booking);
    List<Booking> getAllBookings();
    Booking getBookingById(int id);
    void deleteBooking(int id);
    List<Booking> findByUserId(int userId);
    Map<String, Object> getBookingInfoByUserId(int userId);
}
