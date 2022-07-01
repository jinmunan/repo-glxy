package com.cj.guli.service.edu.feign.fallback;

import com.cj.guli.common.base.result.R;
import com.cj.guli.service.edu.feign.OssFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 备选方案
 * 接口的本地实现
 * @version 1.0
 * @author： jinmunan
 * @date： 2022-07-01 09:11
 */
@Slf4j
@Service
public class OssFileServiceFallBack implements OssFileService {


    @Override
    public R test() {
        return R.error();
    }

    /**
     * 当远程服务oss挂掉了 删除oss照片就需要调用备用方案
     * 不然服务器回宕机
     * @param url
     * @return
     */
    @Override
    public R removeFile(String url) {
        log.info("熔断保护");
        return R.error();
    }
}