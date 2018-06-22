package io;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: shuyizhi
 * @Date: 2018-06-21 14:06
 * @Description:
 */
public class NioReceiver {
    @SuppressWarnings("null")
    public static void main(String[] args) throws Exception {
        ByteBuffer echoBuffer = ByteBuffer.allocate(8);
        ServerSocketChannel ssc = ServerSocketChannel.open();
        Selector selector = Selector.open();
        ssc.configureBlocking(false);
        ServerSocket ss = ssc.socket();
        InetSocketAddress address = new InetSocketAddress(8080);
        ss.bind(address);
        SelectionKey key = ssc.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("开始监听.....");

        while (true) {
            int num = selector.select();
            Set selectedKeys = selector.selectedKeys();
            Iterator iterator = selectedKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey sKey = (SelectionKey) iterator.next();
                SocketChannel channel = null;

            }
        }
    }
}
