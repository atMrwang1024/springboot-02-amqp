package com.atguigu.amqp.service;

import com.atguigu.amqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BookService {

    @RabbitListener(queues = "atguigu.emps")
    public void receive(Book book){
        System.out.println("收到消息："+book);
    }

    @RabbitListener(queues = "gulixueyuan.news")
    public void receive02(Message message){
        System.out.println(Arrays.toString(message.getBody()));
        System.out.println(message.getMessageProperties());
    }

    public void receive03(){
        System.out.println("test");
    }
}
