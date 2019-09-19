package com.lovo.queue;

import java.util.concurrent.ArrayBlockingQueue;

public class TakeQueue extends Thread {

    //持有阻塞式队列
    private ArrayBlockingQueue<String> queue=null;
    private String tag;//标志
    public TakeQueue(ArrayBlockingQueue<String> queue,String tag){
     this.queue=queue;
     this.tag=tag;
    }
    public void run() {
        try {
            while (true) {
                String str = queue.take();
                System.out.println(tag + "获得的结果：" + str);
                Thread.sleep(1000 * 2);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
