package com.penovatech.shopping.service;

import com.penovatech.common.base.service.AbstractServiceImpl;
import com.penovatech.shopping.criteria.CategoryCriteria;
import com.penovatech.shopping.dto.CategoryDto;
import com.penovatech.shopping.mapper.CategoryMapper;
import com.penovatech.shopping.model.Category;
import com.penovatech.shopping.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends AbstractServiceImpl<Category, CategoryCriteria, CategoryDto, Long, CategoryRepository> implements CategoryService {
    public CategoryServiceImpl(CategoryRepository repository,
                               CategoryMapper mapper) {
        super(repository, mapper);
    }
}
