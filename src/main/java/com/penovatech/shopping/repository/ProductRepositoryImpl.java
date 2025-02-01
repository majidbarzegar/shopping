package com.penovatech.shopping.repository;

import com.penovatech.common.base.PredicateBuilder;
import com.penovatech.common.base.repository.AbstractRepositoryImpl;
import com.penovatech.shopping.criteria.ProductCriteria;
import com.penovatech.shopping.model.Product;
import com.penovatech.shopping.model.Product_;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class ProductRepositoryImpl extends AbstractRepositoryImpl<Product, ProductCriteria, Long> implements ProductRepository {

    @Override
    protected void addCondition(PredicateBuilder<Product> predicateBuilder, ProductCriteria criteria) {
        predicateBuilder.addCondition(
                (criteriaBuilder, r) -> criteriaBuilder.greaterThanOrEqualTo(r.get(Product_.CREATED_DATE), criteria.getCreatedDateFrom()),
                Objects.nonNull(criteria.getCreatedDateFrom())
        );
    }

}
