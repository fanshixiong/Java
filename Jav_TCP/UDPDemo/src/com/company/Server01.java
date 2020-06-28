package com.company;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


//还是要等待客户端的消息
public class Server01 {
    public static void main(String[] args) throws Exception {
        //开放端口
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        //接收数据包
        byte[] buffer = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length);

        datagramSocket.receive(datagramPacket);//阻塞接受
        System.out.println(datagramPacket.getAddress().getHostAddress());
        System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));

        datagramSocket.close();
    }
}
