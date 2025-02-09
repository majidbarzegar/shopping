package com.penovatech.shopping.repository;

import com.penovatech.common.base.repository.AbstractJpaRepository;
import com.penovatech.shopping.model.FlashSale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlashSaleRepository extends AbstractJpaRepository<FlashSale, Long> {

    @Query("SELECT fs FROM FlashSale fs WHERE fs.expireAt > :currentTime")
    List<FlashSale> findActiveFlashSales(@Param("currentTime") LocalDateTime currentTime);
}