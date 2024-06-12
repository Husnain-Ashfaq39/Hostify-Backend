package com.arjuncodes.studentsystem.service;

import com.arjuncodes.studentsystem.model.Owner;
import com.arjuncodes.studentsystem.model.User;
import com.arjuncodes.studentsystem.repository.OwnerRepository;
import com.arjuncodes.studentsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository userRepository;

    @Override
    public Owner saveUser(Owner user) {
        return userRepository.save(user);
    }

    @Override
    public List<Owner> getAllUsers() {
        return userRepository.findAll();
    }
}
