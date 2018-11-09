
package com.qq.weixin.mappings;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by serv on 16/4/16.
 */
@Data
public class Group implements Serializable{

    private Integer id;
    private String name;
    private Integer count;

    public Group() {
    }

    public Group(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Group(Integer id, String name, Integer count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

}
