package com.penovatech.shopping.mapper;

import com.penovatech.common.base.mapper.BaseMapper;
import com.penovatech.shopping.dto.CreateFlashSaleDto;
import com.penovatech.shopping.model.FlashSale;
import com.penovatech.shopping.model.Product;
import org.mapstruct.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CreateFlashSaleMapper extends BaseMapper<FlashSale, CreateFlashSaleDto> {

    @Mapping(source = "productList", target = "productIdList", qualifiedByName = "mapProductsToProductIds")
    CreateFlashSaleDto toDto(FlashSale model);

    @Mapping(source = "productIdList", target = "productList", qualifiedByName = "mapProductIdsToProducts")
    FlashSale toModel(CreateFlashSaleDto dto);

    @Mapping(source = "productList", target = "productIdList", qualifiedByName = "mapProductsToProductIds")
    List<CreateFlashSaleDto> toDtoList(List<FlashSale> modelList);

    @Mapping(source = "productIdList", target = "productList", qualifiedByName = "mapProductIdsToProducts")
    List<FlashSale> toModelList(List<CreateFlashSaleDto> dtoList);

    @InheritConfiguration(name = "toModel")
    void updateModelFromDto(@MappingTarget FlashSale model, CreateFlashSaleDto dto);

    @Named("mapProductIdsToProducts")
    default List<Product> mapProductIdsToProducts(List<Long> productIds) {
        if (productIds == null) {
            return new ArrayList<>();
        }
        return productIds.stream().map(Product::new).toList();
    }

    @Named("mapProductsToProductIds")
    default List<Long> mapProductsToProductIds(List<Product> products) {
        if (products == null) {
            return new ArrayList<>();
        }
        return products.stream().map(Product::getId).toList();
    }

    default OffsetDateTime map(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return localDateTime.atOffset(ZoneOffset.UTC);
    }

    default LocalDateTime map(OffsetDateTime offsetDateTime) {
        if (offsetDateTime == null) {
            return null;
        }
        return offsetDateTime.toLocalDateTime();
    }
}

