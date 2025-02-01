package com.penovatech.shopping.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HomeDataResponse {
    private List<BannerDto> banners;

    private List<CategoryDto> categories;

    @JsonProperty("newest_product")
    private List<ProductDto> newestProduct;

    @JsonProperty("flash_sale")
    private FlashSaleDto flashSale;

    @JsonProperty("most_sale")
    private List<ProductDto> mostSale;


}
