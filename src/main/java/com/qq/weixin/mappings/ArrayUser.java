
package com.qq.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by serv on 16/4/23.
 */
@Data
public class ArrayUser implements Serializable {

    @JsonProperty("openid_list")
    private String[] openidList;

    @JsonProperty("to_groupid")
    private Integer toGroupId;

    public ArrayUser(Integer toGroupId, String... openidList) {
        this.toGroupId = toGroupId;
        this.openidList = openidList;
    }

}
