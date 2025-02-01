package com.penovatech.shopping.controller;

import com.penovatech.common.base.controller.AbstractRestController;
import com.penovatech.shopping.criteria.CategoryCriteria;
import com.penovatech.shopping.dto.CategoryDto;
import com.penovatech.shopping.model.Category;
import com.penovatech.shopping.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryRestController extends AbstractRestController<Category, CategoryCriteria, CategoryDto, Long, CategoryService> {
    public CategoryRestController(CategoryService service) {
        super(service);
    }
}
