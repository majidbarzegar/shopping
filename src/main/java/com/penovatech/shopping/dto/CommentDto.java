package com.penovatech.shopping.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
    @JsonProperty("product_id")
    private Long productId;
    @JsonProperty("parent")
    private Long parent;
    private Long userId;
    private String comment;
}
