package com.penovatech.shopping.service;

import com.penovatech.common.base.criteria.SpecPredicateBuilder;
import com.penovatech.common.base.service.AbstractSpecServiceImpl;
import com.penovatech.common.utils.DateUtility;
import com.penovatech.shopping.criteria.ProductCriteria;
import com.penovatech.shopping.mapper.ProductMapper;
import com.penovatech.shopping.model.*;
import com.penovatech.shopping.repository.ProductRepository;
import com.penovatech.shopping.repository.UserLikesProductRepository;
import com.penovatech.shopping.repository.UserRatesProductRepository;
import com.penovatech.shopping.utils.FileService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductServiceImpl extends AbstractSpecServiceImpl<Product, Long, ProductCriteria, ProductRepository> implements ProductService {
    public ProductServiceImpl(ProductRepository repository,
                              ProductMapper mapper,
                              UserRatesProductRepository rateRepository,
                              UserLikesProductRepository likeRepository,
                              FileService fileService) {
        super(repository);
        this.rateRepository = rateRepository;
        this.likeRepository = likeRepository;
        this.fileService = fileService;
    }

    private final FileService fileService;
    private final UserRatesProductRepository rateRepository;
    private final UserLikesProductRepository likeRepository;
    @Value("${image.upload.dir}")
    private String imageUploadDir;

    @Override
    protected void addSpec(SpecPredicateBuilder<Product> predicateBuilder, ProductCriteria criteria) {
        predicateBuilder.greaterThanOrEqualTo(Product_.CREATED_DATE, criteria.getCreatedDateFrom(), null != criteria.getCreatedDateFrom());
        predicateBuilder.equal(Product_.TITLE, criteria.getTitle(), null != criteria.getTitle());
        predicateBuilder.like(Product_.TITLE, criteria.getTitleLike(), null != criteria.getTitleLike());
        predicateBuilder.equal(Product_.PRICE, criteria.getPrice(), null != criteria.getPrice());
        predicateBuilder.greaterThanOrEqualTo(Product_.PRICE, criteria.getPriceFrom(), null != criteria.getPriceFrom());
        predicateBuilder.lessThanOrEqualTo(Product_.PRICE, criteria.getPriceTo(), null != criteria.getPriceTo());
        predicateBuilder.equal("category.id", criteria.getCategoryId(), null != criteria.getCategoryId());
    }

    @Override
    public Product save(Product model, List<MultipartFile> files) {
        for (MultipartFile file : files) {
            String fileName = DateUtility.nowToTimestampWithMillisFormat() + "_" + file.getOriginalFilename();
            model.addImageUrl(fileService.saveFile(file, fileName));
        }
        return super.save(model);
    }

    @Override
    public List<Product> getNewest() {
        ProductCriteria criteria = new ProductCriteria();
        criteria.setCreatedDateFrom(LocalDateTime.now().minusDays(7));
        return this.findAll(criteria);
    }

    @Transactional
    public void likeProduct(Long userId, Long productId) {
        UserProductId id = new UserProductId(userId, productId);
        if (!likeRepository.existsById(id)) {
            likeRepository.save(new UserLikesProduct(id, new User(userId), new Product(productId), LocalDateTime.now()));
        }
    }

    @Transactional
    public void unlikeProduct(Long userId, Long productId) {
        likeRepository.deleteById(new UserProductId(userId, productId));
    }

    @Transactional
    public void rateProduct(Long userId, Long productId, int rating) {
        UserProductId id = new UserProductId(userId, productId);
        UserRatesProduct userRatesProduct = new UserRatesProduct(id, new User(userId), new Product(productId), rating, LocalDateTime.now());
        rateRepository.save(userRatesProduct);
    }

    @Transactional
    public void unRateProduct(Long userId, Long productId) {
        rateRepository.deleteById(new UserProductId(userId, productId));
    }

    public long getProductLikeCount(Long productId) {
        return likeRepository.countByIdProductId(productId);
    }

    public Double getProductAverageRating(Long productId) {
        return rateRepository.findAverageRatingByProductId(productId);
    }

    public Long findMinPrice() {
        return repository.findMinPrice();
    }

    public Long findMaxPrice() {
        return repository.findMaxPrice();
    }
}
