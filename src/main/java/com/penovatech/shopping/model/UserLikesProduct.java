package com.penovatech.shopping.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_USER_LIKES_PRODUCT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"user", "product"}) // Ensures uniqueness in HashSet/Lists
public class UserLikesProduct {
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

    @Column(name = "liked_at", nullable = false, updatable = false)
    private LocalDateTime likedAt;
}
