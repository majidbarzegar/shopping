package com.penovatech.shopping.service;

import com.penovatech.shopping.dto.BannerDto;
import com.penovatech.shopping.dto.CategoryDto;
import com.penovatech.shopping.dto.HomeDataResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    public HomeServiceImpl(BannerService bannerService,
                           ProductService productService,
                           CategoryService categoryService) {
        this.bannerService = bannerService;
        this.categoryService = categoryService;
        this.productService = productService;
    }

    private final BannerService bannerService;
    private final ProductService productService;
    private final CategoryService categoryService;

    @Override
    public HomeDataResponse getHomeData() {
        List<BannerDto> bannerList = bannerService.getAllDto();
        List<CategoryDto> categoryList = categoryService.getAllDto();
        HomeDataResponse response = new HomeDataResponse();
        response.setBanners(bannerList);
        response.setCategories(categoryList);
        return response;
    }
}
