package com.penovatech.shopping.service;

import com.penovatech.shopping.dto.CreateFlashSaleDto;
import com.penovatech.shopping.model.FlashSale;

import java.util.List;

public interface FlashSaleService {
    List<FlashSale> findActiveFlashSales();
    FlashSale save(CreateFlashSaleDto dto);
}
