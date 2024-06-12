package com.arjuncodes.studentsystem.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Hostel {

    @Id
    @GeneratedValue
    private int id; // Using UUID for the primary key


    private String name;


    private String description;


    private Integer hostelOwnerId;



    private Integer numberOfRooms;


    private String amenities;


    private String location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getHostelOwnerId() {
        return hostelOwnerId;
    }

    public void setHostelOwnerId(Integer hostelOwnerId) {
        this.hostelOwnerId = hostelOwnerId;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
// Getters and setters...
}

