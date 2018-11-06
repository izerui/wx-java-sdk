package com.qq.weixin;

import com.qq.weixin.mappings.QrCode;
import com.qq.weixin.mappings.Ticket;

import java.net.URL;

/**
 * Created by serv on 16/4/24.
 */
public interface QrcodeService {

    Ticket create(QrCode qrCode);

    URL url(String ticket);
}
