package com.demo;

public class TalkStudent {
    public static void main(String[] args) {
        new Thread(new TalkSend(7777, 9999, "localhost")).start();
        new Thread(new TalkReceive(8888, "teacher")).start();
    }
}
