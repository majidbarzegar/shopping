package com.penovatech.shopping.controller;

import com.penovatech.common.dto.ResultDto;
import com.penovatech.shopping.dto.ProductDto;
import com.penovatech.shopping.mapper.ProductMapper;
import com.penovatech.shopping.model.Product;
import com.penovatech.shopping.service.CommentService;
import com.penovatech.shopping.service.ProductService;
import com.penovatech.shopping.utils.SessionUtility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductRestController /*extends AbstractRestController<Product, ProductCriteria, ProductDto, Long, ProductService>*/ {

    public ProductRestController(ProductService service, CommentService commentService, ProductMapper mapper) {
        this.commentService = commentService;
        this.service = service;
        this.mapper = mapper;
    }

    private final CommentService commentService;
    private final ProductService service;
    private final ProductMapper mapper;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResultDto<Product> save(@RequestParam("dto") String dtoJson,
                                   @RequestParam("file") List<MultipartFile> files) throws JsonProcessingException {
        ProductDto productDto = new ObjectMapper().readValue(dtoJson, ProductDto.class);
        return new ResultDto<>(service.save(mapper.toModel(productDto), files));
    }

    @PostMapping("/{productId}/like")
    public ResultDto<Void> likeProduct(@PathVariable Long productId) {
        service.likeProduct(SessionUtility.getCurrentUserId(), productId);
        return new ResultDto<>();
    }

    @DeleteMapping("/{productId}/like")
    public ResultDto<Void> unlikeProduct(@PathVariable Long productId) {
        service.unlikeProduct(SessionUtility.getCurrentUserId(), productId);
        return new ResultDto<>();
    }

    @PostMapping("/{productId}/rate")
    public ResultDto<Void> rateProduct(@PathVariable Long productId, @RequestParam int rating) {
        service.rateProduct(SessionUtility.getCurrentUserId(), productId, rating);
        return new ResultDto<>();
    }

    @DeleteMapping("/{productId}/rate")
    public ResultDto<Void> unRateProduct(@PathVariable Long productId) {
        service.unRateProduct(SessionUtility.getCurrentUserId(), productId);
        return new ResultDto<>();
    }

    @GetMapping("/{productId}/likes")
    public ResultDto<Long> getProductLikes(@PathVariable Long productId) {
        return new ResultDto<>(service.getProductLikeCount(productId));
    }

    @GetMapping("/{productId}/rating")
    public ResultDto<Double> getProductAverageRating(@PathVariable Long productId) {
        return new ResultDto<>(service.getProductAverageRating(productId));
    }

    @DeleteMapping("{productId}/comments")
    public ResultDto<Void> deleteCommentsByProductId(@PathVariable("productId") Long productId) {
        commentService.unCommentProduct(SessionUtility.getCurrentUserId(), productId);
        return new ResultDto<>("Comment", "Comments removed successfully", Boolean.TRUE);
    }
}
