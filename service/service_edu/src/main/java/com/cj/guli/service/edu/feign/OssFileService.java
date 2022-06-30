package com.cj.guli.service.edu.feign;

import com.cj.guli.common.base.result.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 去调用Oss服务的test接口
 *
 * @version 1.0
 * @author： jinmunan
 * @date： 2022-06-27 15:30
 */

@Service
@FeignClient("service-oss")
public interface OssFileService {

	@GetMapping("/admin/oss/file/test")
	R test();

	@DeleteMapping("/admin/oss/file/remove")
	R removeFile(@RequestBody String url);

}