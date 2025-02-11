package com.penovatech.shopping.service;

import com.penovatech.common.base.service.AbstractServiceImpl;
import com.penovatech.common.utils.DateUtility;
import com.penovatech.shopping.model.Banner;
import com.penovatech.shopping.repository.BannerRepository;
import com.penovatech.shopping.utils.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BannerServiceImpl extends AbstractServiceImpl<Banner, Long, BannerRepository> implements BannerService {
    public BannerServiceImpl(BannerRepository repository, FileService fileService) {
        super(repository);
        this.fileService = fileService;
    }

    private final FileService fileService;

    @Value("${banner.file.name.prefix}")
    private String bannerFileNamePrefix;

    @Override
    public Banner save(MultipartFile file) {
        String fileName = bannerFileNamePrefix + "_" + DateUtility.nowToTimestampWithMillisFormat() + "_" + file.getOriginalFilename();
        return super.save(new Banner(fileService.saveFile(file, fileName)));
    }
}
