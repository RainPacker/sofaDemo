package com.springboot.nio;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @desc File Name: EchoClient
 * Package Name: com.springboot.nio
 * Date: 2020/3/18 10:24
 * @author: Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class EchoClient {

    private final String host;
    private final int    port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws Exception {
        EventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(nioEventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(host, port))
                    .handler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new EchoClientHandler());
                        }
                    });
            ChannelFuture future = bootstrap.connect().sync(); // 连接到远程；等待连接完成

            future.channel().closeFuture().sync(); // 阻塞到远程; 等待连接完成
        } finally {
            nioEventLoopGroup.shutdownGracefully().sync(); // 关闭线程池和释放所有资源
        }

    }

    public static void main(String[] args) throws Exception {
        final String host = "127.0.0.1";
        final int port = 4567;
        new EchoClient(host, port).start();
    }
}
