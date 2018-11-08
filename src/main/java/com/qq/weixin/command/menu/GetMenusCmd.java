package com.qq.weixin.command.menu;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.mappings.Menu;
import okhttp3.Request;
import okhttp3.Response;

import java.util.ArrayList;
import java.util.List;

public class GetMenusCmd extends Cmd<List<Menu>> {
    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url(BASE_URL + "menu/get")
                .get()
                .build();
        return request;
    }

    @Override
    public List<Menu> response(ObjectMapper mapper, Response response) throws Exception {
        List<Menu> menus = new ArrayList<>();
        JsonNode jsonNode = mapper.readTree(response.body().bytes());
        Menu defaultMenu = mapper.readValue(jsonNode.path("menu").toString(), Menu.class);
        menus.add(defaultMenu);
        if (jsonNode.has("conditionalmenu")) {
            List<Menu> conditionalMenus = mapper.readValue(jsonNode.path("conditionalmenu").toString(), getCollectionType(mapper, Menu.class));
            menus.addAll(conditionalMenus);
        }
        return menus;
    }
}
