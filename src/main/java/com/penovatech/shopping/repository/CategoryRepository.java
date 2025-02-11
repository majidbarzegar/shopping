package com.penovatech.shopping.repository;

import com.penovatech.common.base.repository.AbstractJpaRepository;
import com.penovatech.shopping.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends AbstractJpaRepository<Category, Long> {
}
