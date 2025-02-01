package com.penovatech.shopping.service;

public interface CommentService {
    void commentProduct(Long userId, Long productId, String comment);

    void unCommentProduct(Long userId, Long productId);

    void unCommentProduct(Long id);
}
