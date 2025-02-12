package com.penovatech.shopping.repository;

import com.penovatech.common.base.repository.AbstractJpaRepository;
import com.penovatech.shopping.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends AbstractJpaRepository<Product, Long> {

    @Query("SELECT MIN(p.price) FROM Product p")
    Long findMinPrice();

    @Query("SELECT MAX(p.price) FROM Product p")
    Long findMaxPrice();

}
