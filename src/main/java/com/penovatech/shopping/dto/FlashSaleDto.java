package com.penovatech.shopping.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.penovatech.common.model.AbstractDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class FlashSaleDto extends AbstractDto<Long> {
    @JsonProperty("expired_at")
    private LocalDateTime expireAt;

    @JsonProperty("start_at")
    private LocalDateTime startAt;

    @JsonProperty("products")
    private List<ProductDto> productDtoList;
}
