package com.lpnu.service.impl;

import com.lpnu.dto.BookmarkDTO;
import com.lpnu.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Override
    public BookmarkDTO getCartByUserId(final Long userId) {
        return null;
    }

    @Override
    public BookmarkDTO addBookToCart(final Long userId, final Long bookId) {
        return null;
    }
}