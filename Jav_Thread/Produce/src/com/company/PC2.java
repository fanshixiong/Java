package com.company;
//标志位
public class PC2 {
    public static void main(String[] args) {
        TV tv = new TV();
        new Actor(tv).start();
        new Watcher(tv).start();
    }
}

//生产者，演员
class Actor extends Thread{
    private TV tv;

    public Actor(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i % 2 == 0){
                this.tv.play("kuaiben");
            }
            else{
                this.tv.play("douyan");
            }
        }
    }
}

//消费者，观众
class Watcher extends Thread{
    private TV tv;

    public Watcher(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

//产品，节目
class TV{
    String voice;
    boolean flag = true;

    public synchronized void play(String voice){

        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("演员表演了: "+ voice);

        this.notifyAll();
        this.voice = voice;
        this.flag = !this.flag;

    }

    public synchronized void watch(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("观看了" + voice);
        this.notifyAll();
        this.flag = !this.flag;

    }
}