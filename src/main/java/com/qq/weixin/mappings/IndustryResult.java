package com.qq.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class IndustryResult {

    @JsonProperty("primary_industry")
    private Industry primaryIndustry;

    @JsonProperty("secondary_industry")
    private Industry secondaryIndustry;

    @Data
    public static class Industry {
        @JsonProperty("first_class")
        private String firstClass;

        @JsonProperty("second_class")
        private String secondClass;
    }

}
