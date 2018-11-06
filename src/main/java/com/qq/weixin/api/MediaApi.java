package com.qq.weixin.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.converter.Converter;
import com.qq.weixin.converter.DefaultConverter;
import com.qq.weixin.mappings.MaterialStatus;
import com.qq.weixin.mappings.MediaStatus;
import com.qq.weixin.mappings.News;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by serv on 16/4/25.
 */
public interface MediaApi {

    /**
     * 新增临时素材
     * https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1444738726
     * @param media
     * @param type
     * @param accessToken
     * @return
     */
    @POST("media/upload")
    Call<MediaStatus> upload(@Body MultipartBody media, @Query("type") String type, @Query("access_token") String accessToken);


    /**
     * 上传图文消息内的图片获取URL
     * @param media
     * @param accessToken
     * @return
     */
    @POST("media/uploadimg")
    @Converter(UploadImgConverter.class)
    Call<String> uploadImg(@Body MultipartBody media, @Query("access_token") String accessToken);

    @POST("material/add_material")
    Call<MaterialStatus> addMaterial(@Body MultipartBody media, @Query("access_token") String accessToken);

    @POST("material/add_news")
    @Converter(AddNewsConverter.class)
    Call<String> addNewses(@Body List<News> newses, @Query("access_token") String accessToken);


    /**
     * 获取临时素材
     * https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1444738727
     * @param mediaId
     * @param accessToken
     * @return
     */
    @GET("media/get")
    Call<Void> get(@Query("media_id") String mediaId, @Query("access_token") String accessToken);


    class UploadImgConverter extends DefaultConverter<List<MultipartBody.Part>, String> {
        @Override
        public String response(ObjectMapper mapper, Type type, byte[] response) throws IOException {
            return mapper.readTree(response).path("url").asText();
        }
    }

    class AddNewsConverter extends DefaultConverter<List<News>, String> {
        @Override
        public byte[] request(ObjectMapper mapper, Type type, List<News> newses) throws IOException {
            Map map = new HashMap();
            map.put("articles", newses);
            return mapper.writeValueAsBytes(map);
        }

        @Override
        public String response(ObjectMapper mapper, Type type, byte[] response) throws IOException {
            JsonNode jsonNode = mapper.readTree(response);
            return jsonNode.path("media_id").asText();
        }
    }
}
