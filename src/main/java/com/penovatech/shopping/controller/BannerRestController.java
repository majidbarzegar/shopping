package com.penovatech.shopping.controller;

import com.penovatech.common.base.controller.AbstractRestController;
import com.penovatech.common.base.mapper.BaseMapper;
import com.penovatech.shopping.criteria.BannerCriteria;
import com.penovatech.shopping.dto.BannerDto;
import com.penovatech.shopping.mapper.BannerMapper;
import com.penovatech.shopping.model.Banner;
import com.penovatech.shopping.service.BannerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/banner")
public class BannerRestController extends AbstractRestController<Banner, BannerDto, Long, BannerService, BannerMapper> {

    public BannerRestController(BannerService service, BannerMapper mapper) {
        super(service, mapper);
    }
}
