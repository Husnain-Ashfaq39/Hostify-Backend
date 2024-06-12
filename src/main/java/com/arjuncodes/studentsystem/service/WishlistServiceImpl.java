package com.arjuncodes.studentsystem.service;

import com.arjuncodes.studentsystem.model.Wishlist;
import com.arjuncodes.studentsystem.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Override
    public Wishlist saveWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    @Override
    public void deleteWishlist(Wishlist wishlist) {
        wishlistRepository.delete(wishlist);
    }

    @Override
    public Wishlist findByUserIdAndHostelId(int userId, int hostelId) {
        return wishlistRepository.findByUserIdAndHostelId(userId, hostelId);
    }

    @Override
    public List<Wishlist> findAllByUserId(int userId) {
        return wishlistRepository.findAllByUserId(userId);
    }
}
