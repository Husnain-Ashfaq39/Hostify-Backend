package com.arjuncodes.studentsystem.service;

import com.arjuncodes.studentsystem.model.Owner;
import com.arjuncodes.studentsystem.model.User;

import java.util.List;

public interface OwnerService {
    public Owner saveUser(Owner user);
    public List<Owner> getAllUsers();
}
