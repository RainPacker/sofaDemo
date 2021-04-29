/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.designpatterns.brige;

/**
 * 具体的实现化角色
 * @author rain
 * @version : AviFile.java, v 0.1 2020年12月29日 下午3:49 rain Exp $
 */
public class AviFile implements  VideoFile {
    @Override
    public void decode(String fileName) {
        System.out.println("avi视频文件："+fileName);
    }
}
