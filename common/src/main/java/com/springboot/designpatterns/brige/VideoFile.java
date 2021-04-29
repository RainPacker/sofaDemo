/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.designpatterns.brige;

/**
 * 抽象实现化角色
 * @author rain
 * @version : VideoFile.java, v 0.1 2020年12月29日 下午3:44 rain Exp $
 */
public  interface VideoFile {
    /**
     * 视频解码
     * @param videofile
     */
    void decode(String videofile);

}
