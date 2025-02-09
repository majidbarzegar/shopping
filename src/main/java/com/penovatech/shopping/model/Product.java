package com.penovatech.shopping.model;

import com.penovatech.common.model.AbstractAuditable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_PRODUCT")
@Getter
@Setter
@SequenceGenerator(name = "sequence", sequenceName = "PRODUCT_SEQ", allocationSize = 1)
@NoArgsConstructor
@AllArgsConstructor
public class Product extends AbstractAuditable<Long> {

    public Product(Long id) {
        super(id);
    }

    private String title;
    private String description;
    private Long price;

    @ElementCollection
    private List<String> imageUrls = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserLikesProduct> likedByUsers = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserRatesProduct> ratedByUsers = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
    }

    @Transient
    public long getLikeCount() {
        return likedByUsers.size();
    }

    @Transient
    public double getAverageRating() {
        return ratedByUsers.isEmpty() ? 0.0 :
                ratedByUsers.stream().mapToDouble(UserRatesProduct::getRating).average().orElse(0.0);
    }

    public void addImageUrl(String imageUrl){
        if(null == imageUrls){
            imageUrls = new ArrayList<>();
        }
        imageUrls.add(imageUrl);
    }
}