package com.arjuncodes.studentsystem.service;

import com.arjuncodes.studentsystem.model.Hostel;
import com.arjuncodes.studentsystem.repository.HostelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class HostelServiceImpl implements HostelService {

    @Autowired
    private HostelRepository hostelRepository;

    @Override
    public Hostel createHostel(Hostel hostel) throws IOException {
        return hostelRepository.save(hostel);
    }

    @Override
    public List<Hostel> getAllHostels() {
        return hostelRepository.findAll();
    }

    @Override
    public Hostel getHostelById(Long id) {
        Optional<Hostel> hostel = hostelRepository.findById(Math.toIntExact(id));
        return hostel.orElse(null);
    }

    @Override
    public Hostel updateHostel(Hostel hostel) {
        return hostelRepository.save(hostel);
    }

    @Override
    public void deleteHostel(Long id) {
        hostelRepository.deleteById(Math.toIntExact(id));
    }
}
