package com.lovo.client.mq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MQController {
   @Autowired
    private ActiveMQQueue mqQueue; //注入MQ

    @Autowired
    private ActiveMQTopic mqTopic;//注入订阅发布
    //注入MQ操作模板
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;




    @RequestMapping("sendMQ")
    @ResponseBody
    public  String  sendMQ(String str){
        //发送消息
        jmsMessagingTemplate.convertAndSend(mqQueue,"hello mq");
        return "send mq ok";
    }
    @RequestMapping("sendTopic")
    @ResponseBody
    public  String  sendTopic(String str){
        //发送消息
        jmsMessagingTemplate.convertAndSend(mqTopic,"hello topic");
        return "send topic ok";
    }

}
