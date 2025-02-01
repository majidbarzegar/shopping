package com.penovatech.shopping.repository;

import com.penovatech.shopping.model.UserLikesProduct;
import com.penovatech.shopping.model.UserProductId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLikesProductRepository extends JpaRepository<UserLikesProduct, UserProductId> {

    boolean existsById(UserProductId id);

    @Transactional
    void deleteById(UserProductId id);

    long countByIdProductId(Long productId);
}