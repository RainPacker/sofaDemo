/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.designpatterns.brige;

/**
 * 具体的实现化角色
 * @author rain
 * @version : RmvbFile.java, v 0.1 2020年12月29日 下午3:52 rain Exp $
 */
public class RmvbFile implements  VideoFile {
    @Override
    public void decode(String fileName) {
        System.out.println("rmvb视频文件："+fileName);
    }
}
