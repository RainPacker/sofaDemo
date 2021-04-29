package com.springboot.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class NIOClient {
    public static Selector      selector;
    public static SocketChannel clntChan;

    public static void main(String[] args) throws IOException {
        selector = Selector.open();
        clntChan = SocketChannel.open();
        clntChan.configureBlocking(false);
        clntChan.connect(new InetSocketAddress("localhost", 9999));
        clntChan.register(selector, SelectionKey.OP_WRITE);
        clntChan.write(ByteBuffer.wrap("11113333".getBytes()));
    }
}
