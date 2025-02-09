package com.penovatech.shopping.controller;

import com.penovatech.common.dto.ResultDto;
import com.penovatech.shopping.dto.HomeDataResponse;
import com.penovatech.shopping.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class HomeRestController {

    private final HomeService service;

    @GetMapping("home")
    private ResultDto<HomeDataResponse> getHomeData(){
        return new ResultDto<>(
                service.getHomeData(),
                "Home",
                "Home"
        );
    }
}
