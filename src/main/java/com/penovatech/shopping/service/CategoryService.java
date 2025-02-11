package com.penovatech.shopping.service;

import com.penovatech.common.base.service.AbstractService;
import com.penovatech.shopping.criteria.CategoryCriteria;
import com.penovatech.shopping.dto.CategoryDto;
import com.penovatech.shopping.model.Banner;
import com.penovatech.shopping.model.Category;
import org.springframework.web.multipart.MultipartFile;

public interface CategoryService extends AbstractService<Category, Long> {
    Category save(Category category, MultipartFile file);
}
