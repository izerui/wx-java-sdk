
package com.qq.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by serv on 16/4/15.
 */
@Data
public class AccessToken implements Serializable {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private Long expiresIn;

    //获取token时的毫秒级
    private Long tokenTimeMillis = System.currentTimeMillis();

}
