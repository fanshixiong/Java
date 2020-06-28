package com.company;

public class RaceDemo implements Runnable{
    private static String winner;
    @Override
    public void run() {
        for (int i = 0; i < 101; i++) {
            if(Thread.currentThread().getName() == "兔子" && (i % 51 == 0)){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if(gameOver(i)) break;
            System.out.println(Thread.currentThread().getName() + "run " + i + " steps");
        }
    }
    public boolean gameOver(int steps){
        if(winner != null) return true;
        if(steps >= 100){
            winner = Thread.currentThread().getName();
            System.out.println("winner is " + winner);
        }
        return false;
    }
    public static void main(String[] args) {
        RaceDemo raceDemo = new RaceDemo();
        new Thread(raceDemo, "兔子").start();
        new Thread(raceDemo, "乌龟").start();
    }
}
