package com.cj.guli.service.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.cj.guli.service.oss.service.FileService;
import com.cj.guli.service.oss.util.OssProperties;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.UUID;

/**
 * Created by Jinmunan
 * 2022/6/27
 * 9:06
 *
 * @author THINKPAD
 */

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private OssProperties ossProperties;

    @Override
    public String upload(InputStream inputStream, String module, String originalFilename) {

        String endpoint = ossProperties.getEndpoint();
        String keyid = ossProperties.getKeyid();
        String keysecret = ossProperties.getKeysecret();
        String bucketname = ossProperties.getBucketname();

        //判断oss实例是否存在：如果不存在则创建，如果存在则获取
        OSS ossClient = new OSSClientBuilder().build(endpoint, keyid, keysecret);
        if (!ossClient.doesBucketExist(bucketname)) {
            //创建bucket
            ossClient.createBucket(bucketname);
            //设置oss实例的访问权限：公共读
            ossClient.setBucketAcl(bucketname, CannedAccessControlList.PublicRead);
        }

        //构建日期路径：avatar/2019/02/26/文件名
        String folder = new DateTime().toString("yyyy/MM/dd");

        //文件名：uuid.扩展名
        String fileName = UUID.randomUUID().toString();
        //后缀名 .png
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String key = module + "/" + folder + "/" + fileName + fileExtension;

        //文件上传至阿里云
        ossClient.putObject(ossProperties.getBucketname(), key, inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();

        //返回url地址
        return "https://" + bucketname + "." + endpoint + "/" + key;
    }

    @Override
    public void removeFile(String url) {
        String endpoint = ossProperties.getEndpoint();
        String keyid = ossProperties.getKeyid();
        String keysecret = ossProperties.getKeysecret();
        String bucketname = ossProperties.getBucketname();

        //判断oss实例是否存在：如果不存在则创建，如果存在则获取
        OSS ossClient = new OSSClientBuilder().build(endpoint, keyid, keysecret);
        String host = "https://" + bucketname + "." + endpoint + "/";

        // 获取图片的名字
        String objectName = url.substring(host.length());

        // 删除图片
        ossClient.deleteObject(bucketname, objectName);

        //关闭实例
        ossClient.shutdown();
    }

}
