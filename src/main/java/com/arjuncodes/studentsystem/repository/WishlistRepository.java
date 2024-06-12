package com.arjuncodes.studentsystem.repository;

import com.arjuncodes.studentsystem.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
    Wishlist findByUserIdAndHostelId(int userId, int hostelId);
    List<Wishlist> findAllByUserId(int userId);
}
