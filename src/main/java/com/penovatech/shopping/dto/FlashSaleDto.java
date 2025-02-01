package com.penovatech.shopping.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class FlashSaleDto {
    @JsonProperty("expired_at")
    private LocalDateTime expiredAt;
    private List<ProductDto> products;
}
