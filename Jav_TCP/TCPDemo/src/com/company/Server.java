package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        //要有一个地址
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;
        FileOutputStream receive = null;
        OutputStream os = null;
        try {
            serverSocket = new ServerSocket(9999);
            //等待客户端连接
            socket = serverSocket.accept();

            //读取客户端消息
            inputStream = socket.getInputStream();

            /*中文乱码
            byte[] buffer = new byte[1024];
            int len;
            while((len = inputStream.read(buffer)) != -1){
                String msg = new String (buffer, 0, len);
                System.out.println(msg);
            }
            */
            //管道流
            //baos = new ByteArrayOutputStream();
            receive = new FileOutputStream(new File("receive.txt"));
            byte[] buffer = new byte[1024];
            int len;
            while((len = inputStream.read(buffer)) != -1){
                //baos.write(buffer, 0, len);
                receive.write(buffer, 0, len);
            }


            //通知客户端接收完毕
            os = socket.getOutputStream();
            os.write("Over".getBytes());

            //关闭资源


        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            //关闭流
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(receive != null){
                try {
                    receive.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
