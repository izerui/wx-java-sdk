package com.qq.weixin.command.groups;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.mappings.Group;
import okhttp3.Request;
import okhttp3.Response;

import java.util.ArrayList;
import java.util.List;

public class GetGroupsCmd implements Cmd<List<Group>> {

    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url(BASE_URL + "groups/get")
                .get()
                .build();
        return request;
    }

    @Override
    public List<Group> response(ObjectMapper mapper, Response response) throws Exception {
        JsonNode jsonNode = mapper.readTree(response.body().string());

        CollectionType collectionType = mapper.getTypeFactory()
                .constructCollectionType(ArrayList.class, Group.class);

        return mapper.readValue(jsonNode.path("groups").toString(), collectionType);
    }
}
