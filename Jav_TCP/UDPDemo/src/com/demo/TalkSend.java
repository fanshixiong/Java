package com.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class TalkSend implements Runnable {
    DatagramSocket datagramSocket = null;
    BufferedReader bufferedReader = null;

    private int fromPort;
    private int toPort;
    private String toIP;

    public TalkSend(int fromPort, int toPort, String toIP) {
        this.fromPort = fromPort;
        this.toPort = toPort;
        this.toIP = toIP;
        try {
            datagramSocket = new DatagramSocket(fromPort);
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (true) {
            try {
                String data = bufferedReader.readLine();
                byte[] buffer = data.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length, new InetSocketAddress(this.toIP, this.toPort));
                datagramSocket.send(packet);
                if (data.trim().equals("bye")) {
                    break;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        datagramSocket.close();
    }
}
