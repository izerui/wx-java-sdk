
package com.qq.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by serv on 16/4/24.
 */
@Data
public class Ticket implements Serializable {

    @JsonProperty("ticket")
    private String ticket;

    @JsonProperty("expire_seconds")
    private Integer expireSeconds;

    @JsonProperty("url")
    private String url;

    public String getPicUrl() {
        return "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + ticket;
    }

}
