package com.penovatech.shopping.mapper;

import com.penovatech.common.base.mapper.BaseMapper;
import com.penovatech.shopping.dto.UserDto;
import com.penovatech.shopping.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDto> {
    @Override
    void updateModelFromDto(@MappingTarget User model, UserDto dto);
}
