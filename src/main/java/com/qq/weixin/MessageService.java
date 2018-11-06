package com.qq.weixin;

import com.qq.weixin.mappings.Message;
import com.qq.weixin.mappings.Status;

/**
 * Created by serv on 16/4/21.
 */
public interface MessageService {

    Status send(Message message);
}
