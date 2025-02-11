package com.penovatech.shopping.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.penovatech.common.dto.ResultDto;
import com.penovatech.common.exception.BusinessException;
import com.penovatech.common.exception.CommonExceptionMessage;
import com.penovatech.common.model.ValidationGroup;
import com.penovatech.shopping.criteria.ProductCriteria;
import com.penovatech.shopping.dto.ProductDto;
import com.penovatech.shopping.mapper.ProductMapper;
import com.penovatech.shopping.model.Product;
import com.penovatech.shopping.service.CommentService;
import com.penovatech.shopping.service.ProductService;
import com.penovatech.shopping.utils.SessionUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.penovatech.shopping.exception.ShoppingExceptionMessage.INVALID_JSON_INPUT;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductRestController {
    
    private final CommentService commentService;
    private final ProductService service;
    private final ProductMapper mapper;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResultDto<Product> save(@RequestParam("dto") String dtoJson,
                                   @RequestParam("file") List<MultipartFile> files) {
        ProductDto productDto;
        try {
            productDto = new ObjectMapper().readValue(dtoJson, ProductDto.class);
        } catch (Exception ex) {
            throw new BusinessException(INVALID_JSON_INPUT);
        }
        return new ResultDto<>(
                service.save(mapper.toModel(productDto), files),
                "Save Product",
                "Product saved successful"
        );
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultDto<ProductDto> update(@RequestBody @Validated({ValidationGroup.Update.class}) ProductDto dto) {
        Optional<Product> modelOptional = this.service.findById(dto.getId());
        if (modelOptional.isEmpty()) {
            throw new BusinessException(CommonExceptionMessage.RECOURSE_NOT_FOUND);
        }
        Product model = modelOptional.get();
        this.mapper.updateModelFromDto(model, dto);
        Product savedModel = this.service.save(model);
        return new ResultDto<>(
                this.mapper.toDto(savedModel),
                "Update Product",
                "Product updated successful"
        );
    }

    @DeleteMapping("{id}")
    public ResultDto<Void> deleteById(@PathVariable("id") Long id) {
        this.service.deleteById(id);
        return new ResultDto<>(
                "Delete Product",
                "Product deleted successful",
                Boolean.TRUE
        );
    }

    @PutMapping("delete")
    public ResultDto<Void> deleteByCriteria(@RequestBody ProductCriteria criteria) {
        this.service.delete(criteria);
        return new ResultDto<>(
                "Delete Product",
                "Product deleted successful",
                Boolean.TRUE
        );
    }

    @GetMapping("{id}")
    public ResultDto<ProductDto> findById(@PathVariable("id") Long id) {
        Optional<Product> productOptional = this.service.findById(id);
        if (productOptional.isEmpty()) {
            throw new BusinessException(CommonExceptionMessage.RECOURSE_NOT_FOUND);
        }
        return new ResultDto<>(
                mapper.toDto(productOptional.get()),
                "Find Product",
                "Product find successful"
        );
    }

    @GetMapping
    public ResultDto<Page<ProductDto>> findAll(@RequestParam int page, @RequestParam int size) {
        Page<Product> modelPage = this.service.findAll(PageRequest.of(page, size));
        if (CollectionUtils.isEmpty(modelPage.getContent())) {
            return new ResultDto<>(
                    Page.empty(),
                    "Find Product",
                    "Not found any product"
            );
        }
        List<ProductDto> dtoList = modelPage.getContent().stream().map(this.mapper::toDto).collect(Collectors.toList());
        return new ResultDto<>(
                new PageImpl<>(dtoList, modelPage.getPageable(), modelPage.getTotalElements()),
                "Find Product",
                "Product find successful"
        );
    }

    @PostMapping("search")
    public ResultDto<Page<ProductDto>> findAll(@RequestBody ProductCriteria criteria) {
        Page<Product> modelPage = this.service.findAllInPage(criteria);
        if (CollectionUtils.isEmpty(modelPage.getContent())) {
            return new ResultDto<>(
                    Page.empty(),
                    "Find Product",
                    "Not found any product"
            );
        }
        List<ProductDto> dtoList = modelPage.getContent().stream().map(this.mapper::toDto).collect(Collectors.toList());
        return new ResultDto<>(
                new PageImpl<>(dtoList, modelPage.getPageable(), modelPage.getTotalElements()),
                "Find Product",
                "Product find successful"
        );
    }

    @PostMapping("/{productId}/like")
    public ResultDto<Void> likeProduct(@PathVariable Long productId) {
        service.likeProduct(SessionUtility.getCurrentUserId(), productId);
        return new ResultDto<>(
                "Like Product",
                "Product liked successful",
                Boolean.TRUE
        );
    }

    @DeleteMapping("/{productId}/like")
    public ResultDto<Void> unlikeProduct(@PathVariable Long productId) {
        service.unlikeProduct(SessionUtility.getCurrentUserId(), productId);
        return new ResultDto<>(
                "UnLike Product",
                "Product unliked successful",
                Boolean.TRUE
        );
    }

    @PostMapping("/{productId}/rate")
    public ResultDto<Void> rateProduct(@PathVariable Long productId, @RequestParam int rating) {
        service.rateProduct(SessionUtility.getCurrentUserId(), productId, rating);
        return new ResultDto<>(
                "Rate Product",
                "Product rate successful",
                Boolean.TRUE
        );
    }

    @DeleteMapping("/{productId}/rate")
    public ResultDto<Void> unRateProduct(@PathVariable Long productId) {
        service.unRateProduct(SessionUtility.getCurrentUserId(), productId);
        return new ResultDto<>(
                "Rate Product",
                "Product unRate successful",
                Boolean.TRUE
        );
    }

    @GetMapping("/{productId}/likes")
    public ResultDto<Long> getProductLikes(@PathVariable Long productId) {
        return new ResultDto<>(
                service.getProductLikeCount(productId),
                "Product Like Count",
                "Product like count find successful"
        );
    }

    @GetMapping("/{productId}/rating")
    public ResultDto<Double> getProductAverageRating(@PathVariable Long productId) {
        return new ResultDto<>(
                service.getProductAverageRating(productId),
                "Product Average Rate",
                "Product average rate find successful"
        );
    }

    @DeleteMapping("{productId}/comments")
    public ResultDto<Void> deleteCommentsByProductId(@PathVariable("productId") Long productId) {
        commentService.unCommentProduct(SessionUtility.getCurrentUserId(), productId);
        return new ResultDto<>(
                "Comment",
                "Comments removed successfully",
                Boolean.TRUE
        );
    }
}
