package com.spring_101_200.test_101_110.test107_nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

public class HttpServer {

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
                new Thread(new HttpHandler(key)).run();
                // 处理完后，从侍处理的SelectionKey 迭代器中移除当前使用的key
                keyIter.remove();
            }
        }

    }


    private static class HttpHandler implements Runnable{
        private int bufferSize = 1024;
        private String localCharset = "utf-8";
        private SelectionKey key;
        public HttpHandler(SelectionKey key){
            this.key = key;
        }

        @Override
        public void run() {
            try {
                if(key.isAcceptable()){
                    handleAccept();
                }
                if(key.isReadable()){
                    handleRead();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void handleAccept() throws Exception{
            SocketChannel sc =((ServerSocketChannel) key.channel()).accept();
            sc.configureBlocking(false);
            sc.register(key.selector(),SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
        }
        public void handleRead() throws Exception{
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
                // 控制台打印相关
                String [] requstMessage = receeeivedString.split("\r\n");
                for(String s : requstMessage){
                    System.out.println(s);
                    // 遇到空行说明报文头己经打印完成
                    if(s.isEmpty()){
                        break;
                    }
                }
                // 控制台打印首行信息
                String [] firstLine = requstMessage[0].split(" ");
                System.out.println();
                System.out.println("Method :\t" +firstLine[0]);
                System.out.println("url:\t" + firstLine[1]);
                System.out.println("HTTP Version:\t"+firstLine[2] );
                System.out.println();
                // 返回给客户端
                StringBuffer sendString = new StringBuffer();
                sendString.append("HTTP/1.1 200 OK\r\n"); // 响应报文首行，200表示处理成功
                sendString.append("Content-Type:text/html;charset="+localCharset + "\r\n");
                sendString.append("\r\n"); // 报文头结束加一个空行
                sendString.append("<html><head><title>显示报文</title></head><body>");
                sendString.append("接收请求报文信息:<br/>");
                for(String s : requstMessage){
                    sendString.append(s +" <br/>");
                }
                sendString.append("</body></html>");
                buffer = ByteBuffer.wrap(sendString.toString().getBytes(localCharset));
                sc.write(buffer);
                // 关闭Socket
                sc.close();
            }
        }


    }

}
