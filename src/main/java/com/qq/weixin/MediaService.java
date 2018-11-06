package com.qq.weixin;

import com.qq.weixin.mappings.MaterialStatus;
import com.qq.weixin.mappings.Media;
import com.qq.weixin.mappings.MediaStatus;
import com.qq.weixin.mappings.News;

import java.net.URL;
import java.util.List;

/**
 * Created by serv on 16/4/25.
 */
public interface MediaService {

    MediaStatus upload(Media media);

    URL url(String mediaId);

    /**
     * 上传图文消息内的图片获取URL
     *
     * 请注意，本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制。图片仅支持jpg/png格式，大小必须在1MB以下。
     *
     * @param media
     * @return
     */
    String uploadImg(Media media);

    MaterialStatus addMaterial(Media media);

    String addNewses(List<News> news);
}
