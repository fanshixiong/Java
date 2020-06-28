package com.company;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Client01 {

    public static void main(String[] args) throws Exception {
        //建个socket
        DatagramSocket datagramSocket = new DatagramSocket();
        //2.建个包
        String msg = "hello";

        //发送给谁
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9090;
        //数据，长度起始，发送给谁
        DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);
        //发送
        datagramSocket.send(datagramPacket);

        //关闭
        datagramSocket.close();
    }
}
