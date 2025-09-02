package com.my.pharmacy.service;

import com.my.pharmacy.dto.KakaoApiResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;

@Service
@Slf4j
@RequiredArgsConstructor
public class KakaoAddressSearchService {
    private final RestTemplate restTemplate;

    // 환경변수에서 ${KAKAO_REST_API_KEY} 값을 가져와서 사용
    @Value("${KAKAO_REST_API_KEY}")
    private String kakaoRestApiKey;

    public void apikeyTest() {
        log.info("====== Kakao API Key : {}", kakaoRestApiKey);
    }

    // 우리가 만들 주소(url)
    // https://dapi.kakao.com/v2/local/search/address.json?query=강남대로 405
    private static final String KAKAO_LOCAL_URL =
            "https://dapi.kakao.com/v2/local/search/address.json";

    public KakaoApiResponseDto requestAddressSearch(String address) {
        // 건네받은 주소가 비어있는 경우
        if (ObjectUtils.isEmpty(address)) return null;
        // URL 만들기
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(KAKAO_LOCAL_URL);
        uriBuilder.queryParam("query", address);

        // 해석 불가능한 UTF-8 -> 인코딩
        URI uri = uriBuilder.build().encode().toUri();

        log.info("address : {}, uri : {}", address, uri);

        // 헤더 만들기
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION,
                "KakaoAK " + kakaoRestApiKey);
        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);

        // 카카오 API 호출
        return restTemplate
                .exchange(
                        uri,
                        HttpMethod.GET,
                        httpEntity,
                        KakaoApiResponseDto.class
                ).getBody();
    }
}
