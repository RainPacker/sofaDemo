/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.designpatterns.brige;

/**
 * @author rain
 * @version : Mac.java, v 0.1 2020年12月29日 下午4:08 rain Exp $
 */
public class Mac extends  OperatingSystem {
    public Mac(VideoFile videoFile) {
        super(videoFile);
    }

    void play(String fileName) {
            videoFile.decode(fileName);
    }
}
