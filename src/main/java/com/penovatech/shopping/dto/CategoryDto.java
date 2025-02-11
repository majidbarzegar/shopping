package com.penovatech.shopping.dto;

import com.penovatech.common.model.AbstractDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto extends AbstractDto<Long> {
    private String name;
    @JsonProperty("parent")
    private Long parentId;
    @JsonProperty("icon")
    private String iconUrl;
}
