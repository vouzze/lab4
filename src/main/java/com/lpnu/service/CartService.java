package com.lpnu.service;

import com.lpnu.dto.BookmarkDTO;

public interface CartService {

    BookmarkDTO getCartByUserId(Long userId);
    BookmarkDTO addBookToCart(Long userId, Long bookId);
}
