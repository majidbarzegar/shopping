package com.penovatech.shopping.repository;

import com.penovatech.common.base.repository.AbstractRepository;
import com.penovatech.shopping.criteria.ProductCriteria;
import com.penovatech.shopping.model.Product;

public interface ProductRepository extends AbstractRepository<Product, ProductCriteria, Long> {
}
