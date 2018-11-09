
package com.qq.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by serv on 16/4/21.
 */
@Data
public class Menu implements Serializable {

    private List<Button> button;

    @JsonProperty("menuid")
    private Integer menuId;

    private Matchrule matchrule;

    @Data
    public static class Matchrule {

        @JsonProperty("group_id")
        private Integer groupId;

        @JsonProperty("sex")
        private Integer sex;

        @JsonProperty("country")
        private String country;

        @JsonProperty("province")
        private String province;

        @JsonProperty("city")
        private String city;

        @JsonProperty("client_platform_type")
        private String clientPlatformType;

    }

}
