
package com.qq.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by serv on 16/4/23.
 */
@Data
public class UserRemark implements Serializable{

    @JsonProperty("openid")
    private String openId;

    @JsonProperty("remark")
    private String remark;

    public UserRemark(String openId, String remark) {
        this.openId = openId;
        this.remark = remark;
    }
}
