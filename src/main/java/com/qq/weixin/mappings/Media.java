
package com.qq.weixin.mappings;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by serv on 16/4/25.
 */
@Data
public class Media implements Serializable {

    private String fileName;
    private String type;
    private byte[] data;
    private String title;
    private String introduction;


    private Media() {

    }

    private Media(String fileName, String type, byte[] data) {
        this.fileName = fileName;
        this.type = type;
        this.data = data;
    }

    private Media(String fileName, String title, String introduction, byte[] data) {
        this.fileName = fileName;
        this.title = title;
        this.introduction = introduction;
        this.data = data;
        this.type = "video";
    }

    public static Media image(String fileName, byte[] data) {
        return new Media(fileName, "image", data);
    }

    public static Media voice(String fileName, byte[] data) {
        return new Media(fileName, "voice", data);
    }

    public static Media thumb(String fileName, byte[] data) {
        return new Media(fileName, "thumb", data);
    }

    public static Media video(String fileName, String title, String introduction, byte[] data) {
        return new Media(fileName, title, introduction, data);
    }

}
