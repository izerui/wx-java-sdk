package com.qq.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by rocky on 2016/5/4.
 */
@Data
public class KFSession implements Serializable {

    @JsonProperty("kf_account")
    private String KFAccount;

    @JsonProperty("nickname")
    private String nickName;

    @JsonProperty("password")
    private String passWord;

}
