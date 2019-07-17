package com.qq.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AllTemplates {

    @JsonProperty("template_list")
    private List<TemplateInfo> templateList;

    @Data
    public static class TemplateInfo {
        @JsonProperty("template_id")
        private String templateId;
        private String title;
        @JsonProperty("primary_industry")
        private String primaryIndustry;

        @JsonProperty("deputy_industry")
        private String deputyIndustry;
        private String content;
        private String example;
    }
}
