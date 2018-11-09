package tests;

import com.qq.weixin.command.groups.CreateGroupCmd;
import com.qq.weixin.command.groups.DeleteGroupCmd;
import com.qq.weixin.command.groups.GetGroupsCmd;
import com.qq.weixin.command.groups.UpdateGroupCmd;
import com.qq.weixin.mappings.Group;
import com.qq.weixin.mappings.Status;
import org.junit.Test;

import java.util.List;

public class GroupTests implements Constants {

    @Test
    public void testGroups() {
        List<Group> groupList = engine.execute(new GetGroupsCmd(), appId);
        System.out.println(groupList);
    }

    @Test
    public void createGroup() {
        for (int i = 0; i < 10; i++) {
            Group group = engine.execute(new CreateGroupCmd("发发发" + i), appId);
            System.out.println(group);
        }
    }

    @Test
    public void update() {
        Status status = engine.execute(new UpdateGroupCmd(new Group(142, "aaa")), appId);
        System.out.println(status);
    }

    @Test
    public void delete() {
        List<Group> groupList = engine.execute(new GetGroupsCmd(), appId);
        for (Group group : groupList) {
            if (group.getId() > 100) {
                Status delete = engine.execute(new DeleteGroupCmd(group.getId()), appId);
                System.out.println(delete);
            }
        }
    }
}
