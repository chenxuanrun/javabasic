package io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @program: javabasic
 * @description: NIO实例
 * @author: cxr
 * @create: 2019-10-02 19:18
 **/
public class NIOPlainEchoServer {     
    public void server(int port) throws IOException {
        System.out.println("Listening for connections on port "+port);
        ServerSocketChannel serverChannel =ServerSocketChannel.open();
        ServerSocket ss = serverChannel.socket();
        InetSocketAddress address = new InetSocketAddress(port);
        //将ServerSocket绑定到指定的端口李
        ss.bind(address);
        serverChannel.configureBlocking(false);
        Selector selector = Selector.open();
        //将channel注册到Selector里,并说明让Selector关注的点,这里是关注建立连接这个事件
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true){
            try {
                //阻塞等待就绪的Channel.即没有与客户端建立连接前就一直轮询
                selector.select();
            } catch (IOException e) {
                e.printStackTrace();
                //代码省略的部分是结合业务,正常处理异常的逻辑
                break;
            }
            //获取到Selector里所有就绪的SelectedKey实例,每将一个channel注册到一个Selector就会产生一个SelectorKey
            Set<SelectionKey> readyKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator=readyKeys.iterator();
            while (iterator.hasNext()){
                  SelectionKey selectionKey=iterator.next();
                  //将就绪的SelectorKey从Selector中移除,因为马上要处理它,防止重复执行
                iterator.remove();
                try {
                    //若SelectorKey处于Acceptable状态
                    if (selectionKey.isAcceptable()){
                        ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();;
                        //接收客户端的链接
                        SocketChannel client=server.accept();
                        System.out.println("Accepted connection from "+client);
                        client.configureBlocking(false);
                        //像selector注册socketchannel,主要关注读写,并传入一个ByteBuffer实例供读写缓存
                        client.register(selector,SelectionKey.OP_WRITE | SelectionKey.OP_READ, ByteBuffer.allocate(100));
                    }
                    //若SelectorKey处于可读状态
                    if (selectionKey.isReadable()){
                        SocketChannel client = (SocketChannel) selectionKey.channel();
                        ByteBuffer input = (ByteBuffer) selectionKey.attachment();
                        //从channel里读取数据存入ByteBuffer里面
                        client.read(input);
                    }
                    //若SelectorKey处于可写状态
                    if (selectionKey.isWritable()){
                        SocketChannel client = (SocketChannel) selectionKey.channel();
                        ByteBuffer output = (ByteBuffer) selectionKey.attachment();
                        output.flip();
                        //将ByteBuffer里的数据写入到channel里
                        client.write(output);
                        output.compact();
                    }
                }catch (IOException e){
                    selectionKey.cancel();
                    selectionKey.channel().close();
                }
            }
        }
    }
}
