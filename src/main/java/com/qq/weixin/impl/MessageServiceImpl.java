
package com.qq.weixin.impl;

import com.qq.weixin.MessageService;
import com.qq.weixin.api.MessageApi;
import com.qq.weixin.mappings.Message;
import com.qq.weixin.mappings.Status;
import retrofit2.Retrofit;

/**
 * Created by serv on 16/4/21.
 */
public class MessageServiceImpl extends ServiceImpl<MessageApi> implements MessageService {

    public MessageServiceImpl(Retrofit retrofit) {
        super(retrofit);
    }

    @Override
    protected Class<MessageApi> getApiClass() {
        return MessageApi.class;
    }

    @Override
    public Status send(Message message) {
        return execute(api().send(message,accessToken));
    }
}
