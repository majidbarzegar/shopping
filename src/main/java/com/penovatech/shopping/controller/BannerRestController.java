package com.penovatech.shopping.controller;

import com.penovatech.common.dto.ResultDto;
import com.penovatech.common.exception.BusinessException;
import com.penovatech.common.exception.CommonExceptionMessage;
import com.penovatech.common.model.ValidationGroup;
import com.penovatech.shopping.dto.BannerDto;
import com.penovatech.shopping.mapper.BannerMapper;
import com.penovatech.shopping.model.Banner;
import com.penovatech.shopping.service.BannerService;
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

@RestController
@RequestMapping("/api/v1/banner")
@RequiredArgsConstructor
public class BannerRestController {

    private final BannerService service;
    private final BannerMapper mapper;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResultDto<BannerDto> save(@RequestParam("file") MultipartFile file) {
        return new ResultDto<>(
                mapper.toDto(service.save(file)),
                "Save Banner",
                "Banner saved successful"
        );
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultDto<BannerDto> update(@RequestBody @Validated({ValidationGroup.Update.class}) BannerDto dto) {
        Optional<Banner> modelOptional = this.service.findById(dto.getId());
        if (modelOptional.isEmpty()) {
            throw new BusinessException(CommonExceptionMessage.RECOURSE_NOT_FOUND);
        }
        Banner model = modelOptional.get();
        this.mapper.updateModelFromDto(model, dto);
        Banner savedModel = this.service.save(model);
        return new ResultDto<>(
                this.mapper.toDto(savedModel),
                "Update Banner",
                "Banner updated successful"
        );
    }

    @DeleteMapping("{id}")
    public ResultDto<Void> deleteById(@PathVariable("id") Long id) {
        this.service.deleteById(id);
        return new ResultDto<>(
                "Delete Banner",
                "Banner deleted successful",
                true
        );
    }

    @GetMapping("{id}")
    public ResultDto<BannerDto> findById(@PathVariable("id") Long id) {
        Optional<Banner> bannerOptional = this.service.findById(id);
        if (bannerOptional.isEmpty()) {
            throw new BusinessException(CommonExceptionMessage.RECOURSE_NOT_FOUND);
        }
        return new ResultDto<>(
                mapper.toDto(bannerOptional.get()),
                "Find Banner",
                "Banner find successful"
        );
    }

    @GetMapping
    public ResultDto<Page<BannerDto>> findAll(@RequestParam int page, @RequestParam int size) {
        Page<Banner> modelPage = this.service.findAll(PageRequest.of(page, size));
        if (CollectionUtils.isEmpty(modelPage.getContent())) {
            return new ResultDto<>(
                    Page.empty(),
                    "Find Banner",
                    "Not found any banner"
            );
        }
        List<BannerDto> dtoList = modelPage.getContent().stream().map(this.mapper::toDto).collect(Collectors.toList());
        return new ResultDto<>(
                new PageImpl<>(dtoList, modelPage.getPageable(), modelPage.getTotalElements()),
                "Find Banner",
                "Banner find successful"
        );
    }

}
