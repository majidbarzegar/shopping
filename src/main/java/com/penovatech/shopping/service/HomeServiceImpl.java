package com.penovatech.shopping.service;

import com.penovatech.shopping.dto.FlashSaleDto;
import com.penovatech.shopping.dto.HomeDataResponse;
import com.penovatech.shopping.mapper.BannerMapper;
import com.penovatech.shopping.mapper.CategoryMapper;
import com.penovatech.shopping.mapper.ProductMapper;
import com.penovatech.shopping.model.FlashSale;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {
    private final BannerService bannerService;
    private final ProductService productService;
    private final CategoryService categoryService;
    private final ProductMapper productMapper;
    private final BannerMapper bannerMapper;
    private final CategoryMapper categoryMapper;
    private final FlashSaleService flashSaleService;

    @Override
    public HomeDataResponse getHomeData() {
        HomeDataResponse response = new HomeDataResponse();
        response.setBanners(bannerMapper.toDtoList(bannerService.findAll()));
        response.setCategories(categoryMapper.toDtoList(categoryService.findAll()));
        response.setNewestProduct(productMapper.toDtoList(productService.getNewest()));
        response.setMostSale(productMapper.toDtoList(productService.getNewest()));
        List<FlashSale> activeFlashSales = flashSaleService.findActiveFlashSales();
        if (!CollectionUtils.isEmpty(activeFlashSales)) {
            response.setFlashSale(this.toFlashSaleDto(activeFlashSales.getFirst()));
        }
        return response;
    }

    private FlashSaleDto toFlashSaleDto(FlashSale flashSale) {
        FlashSaleDto dto = new FlashSaleDto();
        dto.setExpireAt(flashSale.getExpireAt());
        dto.setProductDtoList(productMapper.toDtoList(flashSale.getProductList()));
        return dto;
    }
}
