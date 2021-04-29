/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.designpatterns.brige;

/**
 * @author rain
 * @version : Windows.java, v 0.1 2020年12月29日 下午4:10 rain Exp $
 */
public class Windows extends OperatingSystem {
    public Windows(VideoFile videoFile) {
        super(videoFile);
    }

    void play(String fileName) {
        videoFile.decode(fileName);
    }
}
