package com.penovatech.shopping.mapper;

import com.penovatech.common.base.mapper.BaseMapper;
import com.penovatech.shopping.dto.BannerDto;
import com.penovatech.shopping.model.Banner;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BannerMapper extends BaseMapper<Banner, BannerDto> {
    @Override
    void updateModelFromDto(@MappingTarget Banner model, BannerDto dto);
}
