package com.gupao.springcloudstream.rabbitmq.web.controller;

import com.gupao.springcloudstream.rabbitmq.stream.producer.MessageProducerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description RabbitMQ Controller
 * @Author yangsong3
 * @Date 2018/9/18 19:57
 **/
@RestController
public class MessageProducerController {
    private final String kafkaTopic;
    private final MessageProducerBean messageProducerBean;
    @Autowired
    public MessageProducerController(@Value("${myKafka.topic}") String kafkaTopic,
                                     MessageProducerBean messageProducerBean) {
        this.kafkaTopic = kafkaTopic;
        this.messageProducerBean = messageProducerBean;
    }

    /**
     *消息接送 -> {@link }
     * @param message
     * @return
     */
    @GetMapping("gjmes/send")
    public String sendMessage(@RequestParam String message){
        messageProducerBean.send(message);
        return "OK";
    }
}
