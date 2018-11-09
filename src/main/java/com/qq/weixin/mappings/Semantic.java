
package com.qq.weixin.mappings;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by serv on 16/4/24.
 */
@Data
public class Semantic implements Serializable {

    private String query;
    private String category;
    private Double latitude;
    private Double longitude;
    private String city;
    private String region;
    private String appid;
    private String uid;

}
