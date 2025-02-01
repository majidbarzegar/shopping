package com.penovatech.shopping.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "TB_USER_COMMENTS_PRODUCT")
@Getter
@Setter
@SequenceGenerator(name = "sequence", sequenceName = "USER_COMMENTS_PRODUCT_SEQ")
@NoArgsConstructor
@AllArgsConstructor
public class UserCommentsProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private LocalDateTime createAt;
}