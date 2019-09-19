package com.lovo.queue;

import java.util.concurrent.ArrayBlockingQueue;

public class PutQueue implements Runnable {
    //持有阻塞式队列
    private ArrayBlockingQueue<String> queue=null;
    private String tag;//标志
    public PutQueue(ArrayBlockingQueue<String> queue, String tag){
        this.queue=queue;
        this.tag=tag;
    }
    public void run() {

        for(int i=0;i<100;i++){
            try {
                queue.put(tag+"：正在放入内容");
                System.out.println(tag+"：正在放入内容");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
