package com.penovatech.shopping.service;

import com.penovatech.common.base.service.AbstractServiceImpl;
import com.penovatech.common.utils.DateUtility;
import com.penovatech.shopping.mapper.CategoryMapper;
import com.penovatech.shopping.model.Category;
import com.penovatech.shopping.repository.CategoryRepository;
import com.penovatech.shopping.utils.FileUtility;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CategoryServiceImpl extends AbstractServiceImpl<Category, Long, CategoryRepository> implements CategoryService {
    public CategoryServiceImpl(CategoryRepository repository,
                               CategoryMapper mapper) {
        super(repository);
    }

    @Value("${category.file.name.prefix}")
    private String categoryFileNamePrefix;

    @Override
    public Category save(Category category, MultipartFile file) {
        String fileName = categoryFileNamePrefix + "_" + DateUtility.nowToTimestampWithMillisFormat() + "_" + file.getOriginalFilename();
        category.setIconUrl(FileUtility.saveFile(file, fileName));
        return super.save(category);
    }

}
