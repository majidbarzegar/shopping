package com.penovatech.shopping.dto;

import com.penovatech.common.model.AbstractDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto extends AbstractDto<Long> {
    private String name;
    private String email;
}
