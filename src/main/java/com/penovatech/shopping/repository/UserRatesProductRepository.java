package com.penovatech.shopping.repository;

import com.penovatech.shopping.model.UserProductId;
import com.penovatech.shopping.model.UserRatesProduct;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRatesProductRepository extends JpaRepository<UserRatesProduct, UserProductId> {

    Optional<UserRatesProduct> findById(UserProductId id);

    @Transactional
    void deleteById(UserProductId id);

    @Query("SELECT AVG(u.rating) FROM UserRatesProduct u WHERE u.product.id = :productId")
    Double findAverageRatingByProductId(@Param("productId") Long productId);
}