package com.my.pharmacy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MetaDto {
    @JsonProperty("total_count")
    private Integer totalCount;
}
