package com.qf.util;

/**
 * @Description
 * @Date 2023/2/14 17:38
 * @Author qinfei
 **/
public class AccessData {

    private String appKey; // 创建用户ID
    private String appSecret; // 对用户ID+jar包记录ID+业务表ID进行MD5加密
    private String data; // 数据

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

