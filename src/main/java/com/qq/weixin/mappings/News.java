
package com.qq.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by serv on 16/4/25.
 */
@Data
public class News implements Serializable {

    private String title;

    @JsonProperty("thumb_media_id")
    private String thumbMediaId;

    private String author;

    private String digest;

    @JsonProperty("show_cover_pic")
    private int showCoverPic;

    private String content;

    @JsonProperty("content_source_url")
    private String contentSourceUrl;

    public static List<News> newses(News... newses){
        return Arrays.asList(newses);
    }

    public News() {
    }

    public News(String title, String thumbMediaId, String author, String digest, int showCoverPic, String content, String contentSourceUrl) {
        this.title = title;
        this.thumbMediaId = thumbMediaId;
        this.author = author;
        this.digest = digest;
        this.showCoverPic = showCoverPic;
        this.content = content;
        this.contentSourceUrl = contentSourceUrl;
    }

}
