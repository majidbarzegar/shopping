package com.penovatech.shopping.repository;

import com.penovatech.common.base.PredicateBuilder;
import com.penovatech.common.base.repository.AbstractRepositoryImpl;
import com.penovatech.shopping.criteria.BannerCriteria;
import com.penovatech.shopping.model.Banner;
import org.springframework.stereotype.Repository;

@Repository
public class BannerRepositoryImpl extends AbstractRepositoryImpl<Banner, BannerCriteria, Long> implements BannerRepository {

    @Override
    protected void addCondition(PredicateBuilder<Banner> predicateBuilder, BannerCriteria criteria) {

    }

}
