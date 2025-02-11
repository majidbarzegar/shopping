package com.penovatech.shopping.repository;

import com.penovatech.common.base.repository.AbstractJpaRepository;
import com.penovatech.shopping.model.Banner;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends AbstractJpaRepository<Banner, Long> {
}
