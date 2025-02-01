package com.penovatech.shopping.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_USER_RATES_PRODUCT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"user", "product"}, callSuper = false)
public class UserRatesProduct {

    @EmbeddedId
    private UserProductId id = new UserProductId();

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Integer rating;

    @Column(nullable = false)
    private LocalDateTime ratedAt;

    @PrePersist
    protected void onCreate() {
        this.ratedAt = LocalDateTime.now();
    }
}