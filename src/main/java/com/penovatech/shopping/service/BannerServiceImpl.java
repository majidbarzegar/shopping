package com.penovatech.shopping.service;

import com.penovatech.common.base.service.AbstractServiceImpl;
import com.penovatech.shopping.criteria.BannerCriteria;
import com.penovatech.shopping.dto.BannerDto;
import com.penovatech.shopping.mapper.BannerMapper;
import com.penovatech.shopping.model.Banner;
import com.penovatech.shopping.repository.BannerRepository;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl extends AbstractServiceImpl<Banner, BannerCriteria, BannerDto, Long, BannerRepository> implements BannerService {
    public BannerServiceImpl(BannerRepository repository,
                             BannerMapper mapper) {
        super(repository, mapper);
    }
}
