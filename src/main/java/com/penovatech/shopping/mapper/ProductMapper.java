package com.penovatech.shopping.mapper;

import com.penovatech.common.base.mapper.BaseMapper;
import com.penovatech.shopping.dto.ProductDto;
import com.penovatech.shopping.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseMapper<Product, ProductDto> {
    @Override
    void updateModelFromDto(@MappingTarget Product model, ProductDto dto);
}
