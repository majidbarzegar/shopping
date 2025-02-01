package com.penovatech.shopping.dto;

import com.penovatech.common.model.AbstractDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ProductDto extends AbstractDto<Long> {
    private String title;
    private String description;
    private Long price;
    @JsonProperty("image")
    private String imageUrl;



    private Integer likes;
    private boolean isLike;
    private Float rate;

}
