package com.cwr.lianshou.thread;

import java.util.Date;

/**
 * Created by cwr on 2021/12/14
 */
public class MyRunnable implements Runnable {
    private String command;

    public MyRunnable(String s) {
        this.command = s;
    }

    @Override
    public String toString() {
        return this.command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Start.time=" + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + "End.time=" + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
