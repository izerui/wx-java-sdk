package com.qq.weixin.command.qrcode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.mappings.QrCode;
import com.qq.weixin.mappings.Status;
import com.qq.weixin.mappings.Ticket;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CreateQrcodeCmd extends Cmd<Ticket> {

    private QrCode qrCode;

    public CreateQrcodeCmd(QrCode qrCode) {
        this.qrCode = qrCode;
    }

    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url(BASE_URL + "qrcode/create")
                .post(RequestBody.create(JSON_TYPE,mapper.writeValueAsBytes(qrCode)))
                .build();
        return request;
    }

    @Override
    public Ticket response(ObjectMapper mapper, Response response) throws Exception {
        return mapper.readValue(response.body().bytes(),Ticket.class);
    }
}
