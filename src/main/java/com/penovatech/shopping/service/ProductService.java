package com.penovatech.shopping.service;

import com.penovatech.common.base.service.AbstractSpecService;
import com.penovatech.shopping.criteria.ProductCriteria;
import com.penovatech.shopping.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService extends AbstractSpecService<Product, Long, ProductCriteria> {

    Product save(Product dto, List<MultipartFile> files);

    List<Product> getNewest();

    void likeProduct(Long userId, Long productId);

    void unlikeProduct(Long userId, Long productId);

    void rateProduct(Long userId, Long productId, int rating);

    void unRateProduct(Long userId, Long productId);

    long getProductLikeCount(Long productId);

    Double getProductAverageRating(Long productId);

    Long findMinPrice();

    Long findMaxPrice();
}
