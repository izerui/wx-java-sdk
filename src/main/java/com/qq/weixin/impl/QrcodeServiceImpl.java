
package com.qq.weixin.impl;

import com.qq.weixin.QrcodeService;
import com.qq.weixin.api.QrcodeApi;
import com.qq.weixin.mappings.QrCode;
import com.qq.weixin.mappings.Ticket;
import retrofit2.Retrofit;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by serv on 16/4/24.
 */
public class QrcodeServiceImpl extends ServiceImpl<QrcodeApi> implements QrcodeService {

    public QrcodeServiceImpl(Retrofit retrofit) {
        super(retrofit);
    }

    @Override
    protected Class<QrcodeApi> getApiClass() {
        return QrcodeApi.class;
    }

    @Override
    public Ticket create(QrCode qrCode) {
        return execute(api().create(qrCode,accessToken));
    }

    @Override
    public URL url(String ticket) {
        try {
            return new URL("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+ URLEncoder.encode(ticket,"UTF-8"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
