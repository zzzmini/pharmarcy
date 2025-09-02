package com.my.pharmacy.service;

import com.my.pharmacy.dto.KakaoApiResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class KakaoAddressSearchServiceTest {
    @Autowired
    KakaoAddressSearchService kakaoAddressSearchService;

    @Autowired
    KakaoCategorySearchService kakaoCategorySearchService;

    @Test
    @DisplayName("API KEY Test")
    void test() {
        kakaoAddressSearchService.apikeyTest();
    }

    @Test
    @DisplayName("Make URI String Test")
    void uriTest() {
        KakaoApiResponseDto dto = new KakaoApiResponseDto();
        dto = kakaoAddressSearchService
                .requestAddressSearch("강남대로 405");
        System.out.println(dto);
    }

    @Test
    @DisplayName("Search Category Test")
    void categoryTest() {
        KakaoApiResponseDto dto = new KakaoApiResponseDto();
        double x = 127.0263154489116;
        double y = 37.49855885145178;
        double radius = 1000;

        dto = kakaoCategorySearchService
                .resultCategorySearch(y, x, radius);
        System.out.println(dto);
    }
}