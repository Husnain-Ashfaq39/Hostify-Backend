package com.arjuncodes.studentsystem.repository;

import com.arjuncodes.studentsystem.model.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HostelRepository extends JpaRepository<Hostel, Integer> {
    // Custom query methods if needed...
}

