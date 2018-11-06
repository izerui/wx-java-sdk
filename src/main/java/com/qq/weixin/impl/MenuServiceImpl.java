
package com.qq.weixin.impl;

import com.qq.weixin.MenuService;
import com.qq.weixin.api.MenuApi;
import com.qq.weixin.mappings.Button;
import com.qq.weixin.mappings.Menu;
import com.qq.weixin.mappings.Status;
import retrofit2.Retrofit;

import java.util.List;

/**
 * Created by serv on 16/4/20.
 */
public class MenuServiceImpl extends ServiceImpl<MenuApi> implements MenuService {

    public MenuServiceImpl(Retrofit retrofit) {
        super(retrofit);
    }

    @Override
    protected Class<MenuApi> getApiClass() {
        return MenuApi.class;
    }

    @Override
    public Status create(List<Button> buttons) {
        return execute(api().create(buttons,accessToken));
    }

    @Override
    public List<Menu> get() {
        return execute(api().get(accessToken));
    }

    @Override
    public Status delete() {
        return execute(api().delete(accessToken));
    }

}
