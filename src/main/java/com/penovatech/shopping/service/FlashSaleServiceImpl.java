package com.penovatech.shopping.service;

import com.penovatech.shopping.dto.CreateFlashSaleDto;
import com.penovatech.shopping.mapper.CreateFlashSaleMapper;
import com.penovatech.shopping.model.FlashSale;
import com.penovatech.shopping.repository.FlashSaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlashSaleServiceImpl implements FlashSaleService {

    private final FlashSaleRepository repository;
    private final CreateFlashSaleMapper createFlashSaleMapper;

    @Override
    public List<FlashSale> findActiveFlashSales() {
        return repository.findActiveFlashSales(LocalDateTime.now());
    }

    public FlashSale save(CreateFlashSaleDto dto){
        FlashSale model = createFlashSaleMapper.toModel(dto);
        return repository.save(model);
    }
}
