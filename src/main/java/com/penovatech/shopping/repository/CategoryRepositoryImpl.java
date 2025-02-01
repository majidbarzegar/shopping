package com.penovatech.shopping.repository;

import com.penovatech.common.base.PredicateBuilder;
import com.penovatech.common.base.repository.AbstractRepositoryImpl;
import com.penovatech.shopping.criteria.CategoryCriteria;
import com.penovatech.shopping.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepositoryImpl extends AbstractRepositoryImpl<Category, CategoryCriteria, Long> implements CategoryRepository {

    @Override
    protected void addCondition(PredicateBuilder<Category> predicateBuilder, CategoryCriteria criteria) {

    }

}
