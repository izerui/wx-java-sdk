
package com.qq.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by serv on 16/4/25.
 */
@Data
public class MaterialStatus implements Serializable{

    @JsonProperty("media_id")
    private String mediaId;

    private String url;

}
