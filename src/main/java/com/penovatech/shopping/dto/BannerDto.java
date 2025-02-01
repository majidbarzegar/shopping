package com.penovatech.shopping.dto;

import com.penovatech.common.model.AbstractDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BannerDto extends AbstractDto<Long> {

    public BannerDto(Long id, String imageUrl) {
        super(id);
        this.imageUrl = imageUrl;
    }

    @JsonProperty("banner")
    private String imageUrl;
}
