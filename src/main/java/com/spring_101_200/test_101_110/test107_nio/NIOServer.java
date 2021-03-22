package com.spring_101_200.test_101_110.test107_nio;

import com.spring_1_100.test_51_60.test53.Hello;
import org.apache.ibatis.annotations.SelectKey;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.logging.Handler;
import java.util.logging.SocketHandler;

public class NIOServer {

    public static void main(String[] args)  throws Exception{
        // 创建ServerSocketChannel ，监听8080端口
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(8080));
        // 设置为非阻塞的模式
        ssc.configureBlocking(false);
        // 为ssc 注册选择器
        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        // 创建处理器
        Handler handler = new Handler(1024);
        while(true){
            //等待请求，每次等待阻塞3s,超过3s后线程继续向下运行，如果传入的0或者不传入参数将一直阻塞
            if(selector.select(3000) == 0){
                System.out.println("等待请求超时...");
                continue;
            }
            System.out.println("处理请求....");
            // 获取处理SelectionKey
            Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();
            while(keyIter.hasNext()){
                SelectionKey key = keyIter.next();
                try {
                    // 接收到连接请求时
                    if(key.isAcceptable()){
                        handler.handleAccept(key);
                    }
                    if(key.isReadable()){
                        handler.handleRead(key);
                    }

                }catch (Exception e ){
                    keyIter.remove();
                    continue;
                }
                // 处理完后，从侍处理的SelectionKey 迭代器中移除当前使用的key
                keyIter.remove();
            }
        }

    }


    private static class Handler{
        private int bufferSize = 1024;
        private String localCharset = "utf-8";
        public Handler(){

        }
        public Handler(int bufferSize){
            this(bufferSize,null);
        }
        public Handler(String localCharset){
            this(-1,localCharset);
        }

        public Handler(int bufferSize,String localCharset){
            if(bufferSize > 0){
                this.bufferSize = bufferSize;
            }
            if (localCharset !=null) {
                this.localCharset = localCharset;
            }
        }

        public void handleAccept(SelectionKey key) throws Exception{
            SocketChannel sc =((ServerSocketChannel) key.channel()).accept();
            sc.configureBlocking(false);
            sc.register(key.selector(),SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
        }
        public void handleRead(SelectionKey key) throws Exception{
            //获取channel
            SocketChannel sc = (SocketChannel)key.channel();
            // 获取buffer并重置
            ByteBuffer buffer = (ByteBuffer)key.attachment();
            buffer.clear();
            // 没有读到内容则关闭
            if(sc.read(buffer) == -1 ){
                sc.close();
            }else{
                // 将buffer转换成读状态
                buffer.flip();
                // 将buffer中接收到的值按localChartset格式编码后保存receivedString
                String receeeivedString     = Charset.forName(localCharset).newDecoder().decode(buffer).toString();
                System.out.println("received from client :" + receeeivedString);
                // 返回数据给客户端
                String sendString = "received data :" + receeeivedString;
                buffer = ByteBuffer.wrap(sendString.getBytes(localCharset));
                sc.write(buffer);
                // 关闭Socket
                sc.close();
            }
        }
    }

}
