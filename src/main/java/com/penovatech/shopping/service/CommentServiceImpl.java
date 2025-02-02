package com.penovatech.shopping.service;

import com.penovatech.shopping.model.Product;
import com.penovatech.shopping.model.User;
import com.penovatech.shopping.model.UserCommentsProduct;
import com.penovatech.shopping.repository.UserCommentsProductRepository;
import com.penovatech.shopping.utils.SessionUtility;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    public CommentServiceImpl(UserCommentsProductRepository commentRepository) {
        this.repository = commentRepository;
    }

    private final UserCommentsProductRepository repository;


    @Transactional
    public void commentProduct(Long userId, Long productId, String comment) {
        UserCommentsProduct model = new UserCommentsProduct();
        model.setText(comment);
        model.setProduct(new Product(productId));
        model.setUser(new User(userId));
        repository.save(model);
    }

    @Transactional
    public void unCommentProduct(Long userId, Long productId) {
        repository.deleteByUserAndProduct(userId, productId);
    }

    @Transactional
    public void unCommentProduct(Long id) {
        Optional<UserCommentsProduct> comment = repository.findById(id);
        if (comment.isEmpty()) {
            throw new RuntimeException();
        }
        if (!comment.get().getUser().getId().equals(SessionUtility.getCurrentUserId())) {
            throw new RuntimeException();
        }
        repository.deleteById(id);
    }
}
