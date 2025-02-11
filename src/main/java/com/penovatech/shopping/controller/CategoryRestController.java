package com.penovatech.shopping.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.penovatech.common.dto.ResultDto;
import com.penovatech.common.exception.BusinessException;
import com.penovatech.common.exception.CommonExceptionMessage;
import com.penovatech.common.model.ValidationGroup;
import com.penovatech.shopping.dto.CategoryDto;
import com.penovatech.shopping.mapper.CategoryMapper;
import com.penovatech.shopping.model.Category;
import com.penovatech.shopping.service.CategoryService;
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
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryRestController {

    private final CategoryService service;
    private final CategoryMapper mapper;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResultDto<CategoryDto> save(@RequestParam("dto") String dtoJson,
                                       @RequestParam("file") MultipartFile file) {
        CategoryDto categoryDto;
        try {
            categoryDto = new ObjectMapper().readValue(dtoJson, CategoryDto.class);
        } catch (Exception ex) {
            throw new BusinessException(INVALID_JSON_INPUT);
        }
        return new ResultDto<>(
                mapper.toDto(service.save(mapper.toModel(categoryDto), file)),
                "Save Category",
                "Category saved successful"
        );
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultDto<CategoryDto> update(@RequestBody @Validated({ValidationGroup.Update.class}) CategoryDto dto) {
        Optional<Category> modelOptional = this.service.findById(dto.getId());
        if (modelOptional.isEmpty()) {
            throw new BusinessException(CommonExceptionMessage.RECOURSE_NOT_FOUND);
        }
        Category model = modelOptional.get();
        this.mapper.updateModelFromDto(model, dto);
        Category savedModel = this.service.save(model);
        return new ResultDto<>(
                this.mapper.toDto(savedModel),
                "Update Category",
                "Category updated successful"
        );
    }

    @DeleteMapping("{id}")
    public ResultDto<Void> deleteById(@PathVariable("id") Long id) {
        this.service.deleteById(id);
        return new ResultDto<>(
                "Delete Category",
                "Category deleted successful",
                true
        );
    }

    @GetMapping("{id}")
    public ResultDto<CategoryDto> findById(@PathVariable("id") Long id) {
        Optional<Category> categoryOptional = this.service.findById(id);
        if (categoryOptional.isEmpty()) {
            throw new BusinessException(CommonExceptionMessage.RECOURSE_NOT_FOUND);
        }
        return new ResultDto<>(
                mapper.toDto(categoryOptional.get()),
                "Find Category",
                "Category find successful"
        );
    }

    @GetMapping
    public ResultDto<Page<CategoryDto>> findAll(@RequestParam int page, @RequestParam int size) {
        Page<Category> modelPage = this.service.findAll(PageRequest.of(page, size));
        if (CollectionUtils.isEmpty(modelPage.getContent())) {
            return new ResultDto<>(
                    Page.empty(),
                    "Find Category",
                    "Not found any category"
            );
        }
        List<CategoryDto> dtoList = modelPage.getContent().stream().map(this.mapper::toDto).collect(Collectors.toList());
        return new ResultDto<>(
                new PageImpl<>(dtoList, modelPage.getPageable(), modelPage.getTotalElements()),
                "Find Category",
                "Category find successful"
        );
    }
}
