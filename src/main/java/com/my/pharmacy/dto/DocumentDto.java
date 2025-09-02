package com.my.pharmacy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class DocumentDto {
    @JsonProperty("place_name")
    private String placeName;
    @JsonProperty("address_name")
    private String addressName;
    // 위도
    @JsonProperty("y")
    private double latitude;
    // 경도
    @JsonProperty("x")
    private double longitude;
    // 거리
    @JsonProperty("distance")
    private double distance;
}
