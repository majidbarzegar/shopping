package com.penovatech.shopping.model;


import com.penovatech.common.model.AbstractPersistable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "TB_USER_COMMENTS_PRODUCT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "sequence", sequenceName = "USER_COMMENTS_PRODUCT_SEQ", allocationSize = 1)
public class UserCommentsProduct extends AbstractPersistable<Long> {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}