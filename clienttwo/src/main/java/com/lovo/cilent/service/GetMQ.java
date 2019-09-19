package com.lovo.cilent.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service(value = "getMQ")
public class GetMQ {

    @JmsListener(destination = "j171queue")
    public void getMessageQueue(String message){
        System.out.println(message);
    }

    @JmsListener(destination = "j171topic")
    public void getMessageQueue2(String message){
        System.out.println(message+"1");
    }

    @JmsListener(destination = "j171topic")
    public void getMessageQueue3(String message){
        System.out.println(message+"2");
    }
}
