package com.penovatech.shopping.controller;

import com.penovatech.common.base.controller.AbstractRestController;
import com.penovatech.shopping.criteria.CategoryCriteria;
import com.penovatech.shopping.dto.CategoryDto;
import com.penovatech.shopping.mapper.CategoryMapper;
import com.penovatech.shopping.model.Category;
import com.penovatech.shopping.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryRestController extends AbstractRestController<Category, CategoryDto, Long, CategoryService, CategoryMapper> {

    public CategoryRestController(CategoryService service, CategoryMapper mapper) {
        super(service, mapper);
    }
}
