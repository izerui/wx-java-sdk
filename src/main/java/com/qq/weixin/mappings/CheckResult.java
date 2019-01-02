package com.qq.weixin.mappings;

import lombok.Data;

import java.util.List;

@Data
public class CheckResult {
    private List<Dns> dns;
    private List<Ping> ping;
}
