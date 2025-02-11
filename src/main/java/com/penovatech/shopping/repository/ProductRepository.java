package com.penovatech.shopping.repository;

import com.penovatech.common.base.repository.AbstractJpaRepository;
import com.penovatech.shopping.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends AbstractJpaRepository<Product, Long> {
}
