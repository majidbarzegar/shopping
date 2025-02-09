package com.penovatech.shopping.mapper;

import com.penovatech.common.base.mapper.BaseMapper;
import com.penovatech.shopping.dto.ProductDto;
import com.penovatech.shopping.model.Category;
import com.penovatech.shopping.model.Product;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ProductMapper extends BaseMapper<Product, ProductDto> {

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(target = "imageUrls", qualifiedByName = "formatFilePaths")
    ProductDto toDto(Product model);

    @Mapping(source = "categoryId", target = "category", qualifiedByName = "mapCategory")
    Product toModel(ProductDto dto);

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(target = "imageUrls", qualifiedByName = "formatFilePaths")
    List<ProductDto> toDtoList(List<Product> modelList);

    @Mapping(source = "categoryId", target = "category", qualifiedByName = "mapCategory")
    List<Product> toModelList(List<ProductDto> dtoList);

    @InheritConfiguration(name = "toModel")
    void updateModelFromDto(@MappingTarget Product model, ProductDto dto);

    @Named("mapCategory")
    default Category mapCategory(Long categoryId) {
        return (categoryId == null) ? null : new Category(categoryId);
    }

    @Named("formatFilePaths")
    default List<String> formatFilePaths(List<String> filePaths) {
        if (filePaths == null) {
            return new ArrayList<>();
        }
        return filePaths.stream()
                .map(path -> path.replace("\\", "/"))
                .toList();
    }

}
