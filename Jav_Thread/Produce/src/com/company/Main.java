package com.company;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();
        new Producer(synContainer).start();
        new Consumer(synContainer).start();
    }
}

//生产者
class Producer extends Thread{
    SynContainer synContainer;

    public Producer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            synContainer.push(new Chicken(i));
            System.out.println("produce " + i + "chicken");
        }
    }
}
//消费者
class Consumer extends Thread{
    SynContainer synContainer;

    public Consumer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            System.out.println("consume " + synContainer.pop().id + "chicken");
        }
    }
}
//产品
class Chicken{
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}
//缓冲区
class SynContainer{
    private Chicken[] chickens = new Chicken[10];
    private int count = 0;

    //生产者
    public synchronized void push(Chicken chicken){
        if(count == chickens.length){
            //满了，通知消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //没有满, 继续
        chickens[count] = chicken;
        count++;
        this.notifyAll();
    }
    //消费者
    public synchronized Chicken pop() {
        if(count == 0){
            //如果没有产品，消费者等待。
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Chicken chicken = chickens[count];
        this.notifyAll();
        return chicken;
    }
}