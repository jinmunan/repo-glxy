package com.cj.guli.service.oss.service;

import java.io.InputStream;

/**
 * Created by Jinmunan
 * 2022/6/27
 * 8:58
 */
public interface FileService {
    /**
     * 文件上传至阿里云
     * @param inputStream 输入流
     * @param module 文件夹名称
     * @param originalFilename 原始文件名
     * @return 文件在oos服务器上的url地址
     */
    String upload(InputStream inputStream, String module, String originalFilename);
}
