package com.company;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        //要知道服务器的地址,端口号

        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            int port = 9999;

            //创建一个socket连接
            socket = new Socket(serverIP, port);

            //发送消息 IO流
            outputStream = socket.getOutputStream();

            //读取文件：
            fileInputStream = new FileInputStream(new File("1.txt"));

            byte[] buffers = new byte[1024];
            int len;
            while((len = fileInputStream.read(buffers)) != -1){
                outputStream.write(buffers, 0, len);
            }

            //通知服务器，我已经结束了
            socket.shutdownOutput();


            //确定服务器接收完毕，断开连接
            inputStream = socket.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();

            byte[] buffer2 = new byte[1024];
            int len2;
            while((len2 = inputStream.read(buffer2)) != -1){
                byteArrayOutputStream.write(buffer2, 0, len2);
            }

            System.out.println(byteArrayOutputStream.toString());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(byteArrayOutputStream != null){
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
