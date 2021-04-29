/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.designpatterns.brige;

/**
 * 抽象操作系统类（抽象化角色）
 * @author rain
 * @version : OperatingSystem.java, v 0.1 2020年12月29日 下午4:05 rain Exp $
 */
public abstract class OperatingSystem {
    protected VideoFile videoFile;
    public  OperatingSystem(VideoFile videoFile){
        this.videoFile = videoFile;
    }
    abstract void play(String fileName);
}
