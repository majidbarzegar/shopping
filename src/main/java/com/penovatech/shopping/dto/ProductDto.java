package com.penovatech.shopping.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.penovatech.common.model.AbstractDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDto extends AbstractDto<Long> {
    private String title;
    private String description;
    private Long price;
    private Long categoryId;

    @JsonProperty("images")
    private List<String> imageUrls;
    private String image;

    @JsonProperty("likes")
    private Integer likeCount;

    @JsonProperty("isLike")
    private boolean isLike;

    @JsonProperty("rate")
    private Float averageRating;

    public boolean isLike() {
        return null != likeCount && likeCount > 0;
    }

    public String getImage() {
        return imageUrls.getFirst();
    }
}
