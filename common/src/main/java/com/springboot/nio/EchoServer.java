package com.springboot.nio;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @desc File Name: EchoServer
 * Package Name: com.springboot.nio
 * Date: 2020/3/18 09:24
 * @author: Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class EchoServer {

    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start() throws Exception {
        //创建 eventloopgroup
        NioEventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup work = new NioEventLoopGroup();
        try {
            //创建服务引导类
            ServerBootstrap bootstrap = new ServerBootstrap();
            //指定分组
            bootstrap.group(boss, work)
                    //指定使用NIo Channel传输的
                    .channel(NioServerSocketChannel.class)
                    //设置使用的 socket 地址的商品
                    .localAddress(new InetSocketAddress(port))
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    //添加EchoServerHandler 到 chananel
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new EchoServerHandler());
                        }
                    });
            //绑定到服务器 sync 等待服务器关闭
            ChannelFuture future = bootstrap.bind().sync();
            System.out.println(EchoServer.class.getName() + " started and listen  on " + future.channel().localAddress());
            //关闭 channle 和块 直到它关闭
            future.channel().closeFuture().sync();

        } finally {
            //关闭 EventLoopGroup，释放所有资源。
            boss.shutdownGracefully().sync();
            work.shutdownGracefully().sync();
        }

    }

    public static void main(String[] args) throws Exception {
        int port = 4567;
        if (args.length == 1) {
            port = Integer.parseInt(args[0]);
        }
        new EchoServer(port).start(); // 设计端口、启动服务器
    }
}
