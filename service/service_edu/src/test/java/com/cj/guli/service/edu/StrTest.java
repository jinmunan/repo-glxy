package com.cj.guli.service.edu;

/**
 * @version 1.0
 * @author： jinmunan
 * @date： 2022-06-30 17:32
 */
public class StrTest {
    public static void main(String[] args) {
        String bucketname = "123";
        String endpoint = "456";
        String url = "https://123.456/123123";
        String host = "https://" + bucketname + "." + endpoint + "/";
        String object = url.substring(host.length());
        System.out.println(object);
    }
}
