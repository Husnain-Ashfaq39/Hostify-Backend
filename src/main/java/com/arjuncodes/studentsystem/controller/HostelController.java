package com.arjuncodes.studentsystem.controller;

import com.arjuncodes.studentsystem.model.Hostel;
import com.arjuncodes.studentsystem.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hostels")
public class HostelController {
    @Autowired
    private HostelService hostelService;

    // Add GET API to fetch all hostels
    @GetMapping("/getall")
    public ResponseEntity<List<Hostel>> getAllHostels() {
        try {
            List<Hostel> hostels = hostelService.getAllHostels();
            return ResponseEntity.ok().body(hostels);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/addhostel")
    public ResponseEntity<?> addHostel(@RequestBody Hostel hostel) {
        System.out.println("Received hostel data: " + hostel);
        System.out.println("Received hostel data: " + hostel.getHostelOwnerId());

        try {
            hostelService.createHostel(hostel);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving hostel");
        }
    }

    // Update hostel by ID
    @PutMapping("/updatehostel/{id}")
    public ResponseEntity<?> updateHostel(@PathVariable Long id, @RequestBody Hostel hostelDetails) {
        try {
            Hostel existingHostel = hostelService.getHostelById(id);
            if (existingHostel != null) {
                existingHostel.setName(hostelDetails.getName());
                existingHostel.setLocation(hostelDetails.getLocation());
                existingHostel.setHostelOwnerId(hostelDetails.getHostelOwnerId());
                hostelService.updateHostel(existingHostel);
                return ResponseEntity.ok().body("Hostel updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hostel not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating hostel");
        }
    }

    // Delete hostel by ID
    @DeleteMapping("/deletehostel/{id}")
    public ResponseEntity<?> deleteHostel(@PathVariable Long id) {
        try {
            Hostel existingHostel = hostelService.getHostelById(id);
            if (existingHostel != null) {
                hostelService.deleteHostel(id);
                return ResponseEntity.ok().body("Hostel deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hostel not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting hostel");
        }
    }
}
