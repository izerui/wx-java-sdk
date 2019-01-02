package com.qq.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Ping {

    private String ip;

    @JsonProperty("from_operator")
    private String fromOperator;

    @JsonProperty("package_loss")
    private String packageLoss;

    private String time;

}
