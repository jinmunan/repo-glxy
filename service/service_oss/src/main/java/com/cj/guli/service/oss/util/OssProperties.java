package com.cj.guli.service.oss.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by @author Jinmunan
 * 2022/6/27
 * 8:56
 */

@Data
@Component
//注意prefix要写到最后一个 "." 符号之前
@ConfigurationProperties(prefix="aliyun.oss")
public class OssProperties {
    private String endpoint;
    private String keyid;
    private String keysecret;
    private String bucketname;

}
