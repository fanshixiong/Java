package com.demo;

import java.io.BufferedReader;
import java.lang.management.BufferPoolMXBean;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//接受
public class Client01 {

    public static void main(String[] args) throws Exception {
        //建个socket
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        while(true) {

            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
            datagramSocket.receive(packet);


            byte[] data = packet.getData();
            String receiveData = new String(data, 0, packet.getLength());

            System.out.println(receiveData);
            //断开连接
            if(receiveData.equals("bye")){
                break;
            }
        }
        //关闭
        datagramSocket.close();

    }
}
