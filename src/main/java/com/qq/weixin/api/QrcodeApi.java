package com.qq.weixin.api;

import com.qq.weixin.mappings.QrCode;
import com.qq.weixin.mappings.Ticket;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by serv on 16/4/24.
 */
public interface QrcodeApi {

    @POST("qrcode/create")
    Call<Ticket> create(@Body QrCode qrCode, @Query("access_token") String accessToken);


    @GET("https://mp.weixin.qq.com/cgi-bin/showqrcode")
    Call<Void> url(@Query("ticket") String ticket);

}
