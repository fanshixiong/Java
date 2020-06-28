package com.demo;

public class TalkTeacher {
    public static void main(String[] args) {
        new Thread(new TalkSend(5555, 8888, "localhost")).start();
        new Thread(new TalkReceive(9999, "Student")).start();
    }
}
