package com.arjuncodes.studentsystem.service;

import com.arjuncodes.studentsystem.model.Wishlist;

import java.util.List;

public interface WishlistService {
    Wishlist saveWishlist(Wishlist wishlist);
    void deleteWishlist(Wishlist wishlist);
    Wishlist findByUserIdAndHostelId(int userId, int hostelId);
    List<Wishlist> findAllByUserId(int userId);
}
