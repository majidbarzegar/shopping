package com.penovatech.shopping.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchResponse {
    private List<ProductDto> products;
    private Pagination pagination;
}
