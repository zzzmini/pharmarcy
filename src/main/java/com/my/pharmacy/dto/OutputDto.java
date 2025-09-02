package com.my.pharmacy.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class OutputDto {
    private String pharmacyName;
    private String pharmacyAddress;
    private String directionURL; // 길안내 URL
    private String roadViewURL; // 로드뷰 URL
    private String distance;
}
