
package com.qq.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by serv on 2014/7/28.
 */
@Data
public class UserInfo implements Serializable {
    /**
     * 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
     */
    @JsonProperty("subscribe")
    private Integer subscribe;

    /**
     * 用户的唯一标识
     */
    @JsonProperty("openid")
    private String openId;

    /**
     * 用户昵称
     */
    @JsonProperty("nickname")
    private String nickName;

    /**
     * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    @JsonProperty("sex")
    private Integer sex;

    /**
     * 用户的语言，简体中文为zh_CN
     */
    @JsonProperty("language")
    private String language;

    /**
     * 普通用户个人资料填写的城市
     */
    @JsonProperty("city")
    private String city;

    /**
     * 用户个人资料填写的省份
     */
    @JsonProperty("province")
    private String province;

    /**
     * 国家，如中国为CN
     */
    @JsonProperty("country")
    private String country;

    /**
     * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
     */
    @JsonProperty("headimgurl")
    private String headImgUrl;

    /**
     * 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
     */
    @JsonProperty("subscribe_time")
    private Long subscribeTime;

    /**
     * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     */
    @JsonProperty("unionid")
    private String unionId;

    @JsonProperty("remark")
    private String remark;

    @JsonProperty("groupid")
    private Integer groupId;

    @JsonProperty("tagid_list")
    private List<Integer> tagidList;

    @JsonProperty("subscribe_scene")
    private String subscribeScene;

    @JsonProperty("qr_scene")
    private Integer qrScene;

    @JsonProperty("qr_scene_str")
    private String qrSceneStr;

    /**
     * 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
     */
    private List<String> privilege;

    private String appId;

    /**
     * 用户最后跟微信服务交互时间 格式：2015-04-22 10:21:59
     */
    private String kissTime;

}
