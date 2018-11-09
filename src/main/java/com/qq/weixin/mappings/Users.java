
package com.qq.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by serv on 16/4/21.
 */
@Data
public class Users {
    private Integer total;
    private Integer count;

    @JsonProperty("next_openid")
    private String nextOpenId;

    private Data data;


    @lombok.Data
    public static class Data{

        @JsonProperty("openid")
        private List<String> openId;

    }

}
