package com.demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TalkReceive implements Runnable{
    DatagramSocket datagramSocket = null;
    private int port;
    private String msgFrom;

    public TalkReceive(int port, String msgFrom) {
        this.port = port;
        this.msgFrom = msgFrom;
        try {
            datagramSocket = new DatagramSocket(port);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true) {
            try {
                byte[] bytes = new byte[1024];
                DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
                datagramSocket.receive(packet);


                byte[] data = packet.getData();
                String receiveData = new String(data, 0, packet.getLength());

                System.out.println(msgFrom + ": " + receiveData);

                if (receiveData.trim().equals("bye")) {
                    break;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        //关闭
        datagramSocket.close();
    }
}
