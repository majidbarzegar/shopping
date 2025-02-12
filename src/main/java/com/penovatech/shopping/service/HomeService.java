package com.penovatech.shopping.service;

import com.penovatech.shopping.criteria.ProductCriteria;
import com.penovatech.shopping.dto.FilterDateResponse;
import com.penovatech.shopping.dto.HomeDataResponse;
import com.penovatech.shopping.dto.SearchResponse;

public interface HomeService {
    HomeDataResponse getHomeData();

    FilterDateResponse getFilterDate();

    SearchResponse search(ProductCriteria criteria);
}
