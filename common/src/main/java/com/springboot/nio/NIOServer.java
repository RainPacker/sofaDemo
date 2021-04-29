package com.springboot.nio;

import com.springboot.bio.RequestHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);
        serverChannel.bind(new InetSocketAddress(9999));
        System.out.println("NIO  NIOServer has started on port" + serverChannel.getLocalAddress());
        Selector selector = Selector.open();//打开
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        //
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        RequestHandler requestHandler = new RequestHandler();
        while (true) {
            int select = selector.select();
            if (select == 0) {
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                //处理每个客户端的连接操作
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                    SocketChannel clientChannel = serverSocketChannel.accept();
                    System.out.println("Connection from: " + clientChannel.getRemoteAddress());
                    clientChannel.configureBlocking(false);
                    clientChannel.register(selector, SelectionKey.OP_READ);

                }
                if (key.isReadable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    channel.read(byteBuffer);
                    String request = new String(byteBuffer.array()).trim();
                    byteBuffer.clear();
                    System.out.println(String.format("From %s : %s", channel.getRemoteAddress(), request));
                    String response = requestHandler.handler(request);
                    channel.write(ByteBuffer.wrap(response.getBytes()));
                }
                iterator.remove();

            }
        }

    }

}
