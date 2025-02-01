package com.penovatech.shopping.mapper;

import com.penovatech.common.base.mapper.BaseMapper;
import com.penovatech.shopping.dto.CategoryDto;
import com.penovatech.shopping.model.Category;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CategoryMapper extends BaseMapper<Category, CategoryDto> {
    @Mapping(source = "parentCategory.id", target = "parentId")
    CategoryDto toDto(Category model);

    @Mapping(source = "parentId", target = "parentCategory", qualifiedByName = "mapParentCategory")
    Category toModel(CategoryDto dto);

    @Mapping(source = "parentCategory.id", target = "parentId")
    List<CategoryDto> toDtoList(List<Category> modelList);

    @Mapping(source = "parentId", target = "parentCategory", qualifiedByName = "mapParentCategory")
    List<Category> toModelList(List<CategoryDto> dtoList);

    @InheritConfiguration(name = "toModel")
    void updateModelFromDto(@MappingTarget Category model, CategoryDto dto);

    @Named("mapParentCategory")
    default Category mapParentCategory(Long parentId) {
        return (parentId == null) ? null : new Category(parentId);
    }
}