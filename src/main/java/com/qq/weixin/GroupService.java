package com.qq.weixin;

import com.qq.weixin.mappings.Group;
import com.qq.weixin.mappings.Status;

import java.util.List;

/**
 * Created by serv on 16/4/21.
 */
public interface GroupService {
    List<Group> groups();
    Group create(String name);
    Status update(Group group);
    Status delete(Integer groupId);
}
