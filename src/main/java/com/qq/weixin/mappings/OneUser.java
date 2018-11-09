
package com.qq.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by serv on 16/4/23.
 */
@Data
public class OneUser implements Serializable {

    @JsonProperty("openid")
    private String openId;

    @JsonProperty("to_groupid")
    private Integer toGroupId;

    public OneUser(Integer toGroupId, String openId) {
        this.toGroupId = toGroupId;
        this.openId = openId;
    }
}
