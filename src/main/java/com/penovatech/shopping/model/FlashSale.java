package com.penovatech.shopping.model;

import com.penovatech.common.model.AbstractPersistable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_FLASH_SALE")
@Getter
@Setter
@SequenceGenerator(name = "sequence", sequenceName = "FLASH_SALE_SEQ", allocationSize = 1)
public class FlashSale extends AbstractPersistable<Long> {

    @Column(name = "expire_at")
    private LocalDateTime expireAt;

    @Column(name = "start_at")
    private LocalDateTime startAt;

    @ManyToMany
    @JoinTable(
            name = "flash_sale_product",
            joinColumns = @JoinColumn(name = "flash_sale_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productList = new ArrayList<>();
}