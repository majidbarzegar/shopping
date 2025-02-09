package com.penovatech.shopping.repository;

import com.penovatech.common.base.repository.AbstractJpaRepository;
import com.penovatech.shopping.model.UserCommentsProduct;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCommentsProductRepository extends AbstractJpaRepository<UserCommentsProduct, Long> {

    @Transactional
    void deleteById(Long id);

    @Query("SELECT u FROM UserCommentsProduct u WHERE u.product.id = :productId ORDER BY u.createdAt DESC")
    List<UserCommentsProduct> findByProductId(@Param("productId") Long productId);

    @Modifying
    @Query("DELETE FROM UserCommentsProduct u WHERE u.user.id = :userId AND u.product.id = :productId")
    void deleteByUserAndProduct(@Param("userId") Long userId, @Param("productId") Long productId);
}