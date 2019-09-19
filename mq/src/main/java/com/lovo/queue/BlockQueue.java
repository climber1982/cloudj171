package com.lovo.queue;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockQueue {

    public static void main(String[] args) {
        //创建阻塞队列
        ArrayBlockingQueue<String> queue=new ArrayBlockingQueue<>(10);

        //创建存的线程
        PutQueue put1=new PutQueue(queue,"1");
        PutQueue put2=new PutQueue(queue,"2");
        PutQueue put3=new PutQueue(queue,"3");
        Thread t1=new Thread(put1);
        Thread t2=new Thread(put2);
        Thread t3=new Thread(put3);
      //创建取线程
        TakeQueue take1=new TakeQueue(queue,"a");
        TakeQueue take2=new TakeQueue(queue,"b");
        //开启线程
        t1.start();
        t2.start();
        t3.start();
        take1.start();
        take2.start();


    }
}
