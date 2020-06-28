package com.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;


//发送
public class Server01 {
    public static void main(String[] args) throws Exception {
        //开放端口
        DatagramSocket datagramSocket = new DatagramSocket(6666);
        //从控制台读取
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String data = bufferedReader.readLine();
            byte[] buffer = data.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length, new InetSocketAddress("localhost", 8888));
            datagramSocket.send(packet);
            if(data.equals("bye")){
                break;
            }
        }
        datagramSocket.close();
    }
}
