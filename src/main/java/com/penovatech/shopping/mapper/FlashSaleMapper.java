package com.penovatech.shopping.mapper;

import com.penovatech.common.base.mapper.BaseMapper;
import com.penovatech.shopping.dto.FlashSaleDto;
import com.penovatech.shopping.model.FlashSale;
import org.mapstruct.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = ProductMapper.class, // Reuse ProductMapper for mapping Product <-> ProductDto
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface FlashSaleMapper extends BaseMapper<FlashSale, FlashSaleDto> {

    @Mapping(source = "productList", target = "productDtoList")
    FlashSaleDto toDto(FlashSale model);

    @Mapping(source = "productDtoList", target = "productList")
    FlashSale toModel(FlashSaleDto dto);

    @Mapping(source = "productList", target = "productDtoList")
    List<FlashSaleDto> toDtoList(List<FlashSale> modelList);

    @Mapping(source = "productDtoList", target = "productList")
    List<FlashSale> toModelList(List<FlashSaleDto> dtoList);

    @InheritConfiguration(name = "toModel")
    void updateModelFromDto(@MappingTarget FlashSale model, FlashSaleDto dto);

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
        return offsetDateTime.toLocalDateTime(); // Convert to LocalDateTime
    }
}

