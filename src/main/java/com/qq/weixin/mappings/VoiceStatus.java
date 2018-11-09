package com.qq.weixin.mappings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VoiceStatus extends Status {

    @JsonProperty("voice_id")
    private String voiceId;
}
