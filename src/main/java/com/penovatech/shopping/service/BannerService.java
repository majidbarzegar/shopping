package com.penovatech.shopping.service;

import com.penovatech.common.base.service.AbstractService;
import com.penovatech.shopping.model.Banner;
import org.springframework.web.multipart.MultipartFile;

public interface BannerService extends AbstractService<Banner, Long> {
    Banner save(MultipartFile file);
}
