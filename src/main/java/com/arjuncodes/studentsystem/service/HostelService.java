package com.arjuncodes.studentsystem.service;

import com.arjuncodes.studentsystem.model.Hostel;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface HostelService {
    public Hostel createHostel(Hostel hostel) throws IOException;
    public List<Hostel> getAllHostels();
    public Hostel getHostelById(Long id);
    public Hostel updateHostel(Hostel hostel);
    public void deleteHostel(Long id);
}
