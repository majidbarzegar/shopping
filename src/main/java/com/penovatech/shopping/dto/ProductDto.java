package com.penovatech.shopping.dto;

import com.penovatech.common.model.AbstractDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
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

    @JsonProperty("likes")
    private Integer likeCount;

    @JsonProperty("isLike")
    private boolean isLike;

    @JsonProperty("rate")
    private Float averageRating;

    public boolean isLike() {
        return null != likeCount && likeCount > 0;
    }
}
