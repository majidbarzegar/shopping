package com.penovatech.shopping.repository;

import com.penovatech.common.base.repository.AbstractRepository;
import com.penovatech.shopping.criteria.CategoryCriteria;
import com.penovatech.shopping.model.Category;

public interface CategoryRepository extends AbstractRepository<Category, CategoryCriteria, Long> {
}
