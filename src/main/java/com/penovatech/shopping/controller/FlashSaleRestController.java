package com.penovatech.shopping.controller;

import com.penovatech.common.dto.ResultDto;
import com.penovatech.shopping.dto.CreateFlashSaleDto;
import com.penovatech.shopping.model.FlashSale;
import com.penovatech.shopping.service.FlashSaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/flash-sale")
@RequiredArgsConstructor
public class FlashSaleRestController {

    private final FlashSaleService service;

    @PostMapping()
    private ResultDto<FlashSale> save(@RequestBody CreateFlashSaleDto dto) {
        return new ResultDto<>(
                service.save(dto),
                "FlashSale",
                "FlashSale"
        );
    }
}
