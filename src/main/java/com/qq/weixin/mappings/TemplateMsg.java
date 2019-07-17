package com.qq.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class TemplateMsg {

    private String touser;

    @JsonProperty("template_id")
    private String templateId;

    private String url;

    private Miniprogram miniprogram;

    private Map<String, Keyword> data;


    public TemplateMsg(String touser, String templateId, String url, Miniprogram miniprogram, Map<String, Keyword> data) {
        this.touser = touser;
        this.templateId = templateId;
        this.url = url;
        this.miniprogram = miniprogram;
        this.data = data;
    }

    @Data
    public static class Miniprogram {
        private String appid;
        private String pagepath;

        public Miniprogram(String appid, String pagepath) {
            this.appid = appid;
            this.pagepath = pagepath;
        }

        public Miniprogram(String appid) {
            this.appid = appid;
        }
    }

    @Data
    public static class Keyword {
        private String value;
        private String color;

        public Keyword(String value, String color) {
            this.value = value;
            this.color = color;
        }

        public Keyword(String value) {
            this.value = value;
        }
    }
}
