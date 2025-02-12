package com.penovatech.shopping.controller;

import com.penovatech.common.dto.ResultDto;
import com.penovatech.shopping.criteria.ProductCriteria;
import com.penovatech.shopping.dto.FilterDateResponse;
import com.penovatech.shopping.dto.HomeDataResponse;
import com.penovatech.shopping.dto.SearchResponse;
import com.penovatech.shopping.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class HomeRestController {

    private final HomeService service;

    @GetMapping("home")
    private ResultDto<HomeDataResponse> getHomeData() {
        return new ResultDto<>(
                service.getHomeData(),
                "Home",
                "Home date found successful"
        );
    }

    @GetMapping("search/filter")
    private ResultDto<FilterDateResponse> getFilterDate() {
        return new ResultDto<>(
                service.getFilterDate(),
                "FilterDate",
                "Filter data found successful"
        );
    }

    @GetMapping("search")
    private ResultDto<SearchResponse> search(
            @RequestParam(value = "min_price", required = false) Long minPrice,
            @RequestParam(value = "max_price", required = false) Long maxPrice,
            @RequestParam(value = "categories_id", required = false) Long categoryId,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "sort", required = false) String sort
    ) {
        ProductCriteria criteria = new ProductCriteria();
        criteria.setPriceFrom(minPrice);
        criteria.setPriceTo(maxPrice);
        criteria.setCategoryId(categoryId);
        if (null != page && page > 0) {
            criteria.setPage(page - 1);
        } else {
            criteria.setPage(0);
        }
        criteria.setSize(10);
        return new ResultDto<>(
                service.search(criteria),
                "Search",
                "Search data found successful"
        );
    }
}
