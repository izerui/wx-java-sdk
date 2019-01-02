package com.qq.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Dns {

    private String ip;

    @JsonProperty("real_operator")
    private String realOperator;
}
