
package com.qq.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by serv on 16/4/19.
 */
@Data
public class Button implements Serializable {

    @JsonProperty("type")
    private ButtonType type;
    @JsonProperty("name")
    private String name;
    @JsonProperty("key")
    private String key;
    @JsonProperty("url")
    private String url;
    @JsonProperty("media_id")
    private String mediaId;
    @JsonProperty("sub_button")
    private List<Button> subButton;


    public enum ButtonType {
        /**
         * 点击推事件
         */
        click,
        /**
         * 跳转URL
         */
        view,
        /**
         * 扫码推事件
         */
        scancode_push,
        /**
         * 扫码推事件且弹出“消息接收中”提示框
         */
        scancode_waitmsg,
        /**
         * 弹出系统拍照发图
         */
        pic_sysphoto,
        /**
         * 弹出拍照或者相册发图
         */
        pic_photo_or_album,
        /**
         * 弹出微信相册发图器
         */
        pic_weixin,
        /**
         * 弹出地理位置选择器
         */
        location_select,
        /**
         * 下发消息（除文本消息）
         */
        media_id,
        /**
         * 跳转图文消息URL
         */
        view_limited;
    }
}
