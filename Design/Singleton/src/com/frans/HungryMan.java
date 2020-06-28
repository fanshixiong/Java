package com.frans;

//饿汉式单例模式
public class HungryMan {

    //可能会浪费空间
    private byte[] buffer1 = new byte[1024*1024];
    private byte[] buffer2 = new byte[1024*1024];
    private byte[] buffer3 = new byte[1024*1024];
    private byte[] buffer4 = new byte[1024*1024];

    private HungryMan() {
    }

    private final static HungryMan HUNGRY_MAN = new HungryMan();

    public static HungryMan getInstance(){
        return HUNGRY_MAN;
    }
}
