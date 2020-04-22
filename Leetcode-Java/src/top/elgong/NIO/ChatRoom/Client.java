package top.elgong.NIO.ChatRoom;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Client {

    private String nickName;

    public Client(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 启动
     */
    public void start() throws IOException {
        /**
         * 连接服务器端
         */
        SocketChannel socketChannel = SocketChannel.open(
                new InetSocketAddress("127.0.0.1", 8000));


        /**
         * 接收服务器端响应
         */
        // 新开线程，专门负责来接收服务器端的响应数据
        // selector ， socketChannel ， 注册
        Selector selector = Selector.open();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        new Thread(new NioClientHandler(selector)).start();

        // 向服务器端发送数据
        Scanner scanner = new Scanner(System.in);
        System.out.print(nickName + ": ");
        while (scanner.hasNextLine()) {
            System.out.print(nickName + ": ");
            String request = scanner.nextLine();
            if (request != null && request.length() > 0) {
                socketChannel.write(
                        Charset.forName("UTF-8")
                                .encode(nickName + " : " + request));
            }

        }

    }


    static class A{
        public static void main(String[] args) {
            try {
                new Client("elgong").start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class B{
        public static void main(String[] args) {
            try {
                new Client("liqingfeng").start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
