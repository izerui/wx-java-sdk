package com.qq.weixin;

import com.qq.weixin.mappings.Button;
import com.qq.weixin.mappings.Menu;
import com.qq.weixin.mappings.Status;

import java.util.List;

/**
 * Created by serv on 16/4/20.
 */
public interface MenuService{

    Status create(List<Button> buttons);

    List<Menu> get();

    Status delete();

}
