/**
 * @program: demo
 * @description:
 * @author: roamer-徐泽宇
 * @create: 2018-12-23 21:46
 **/

package pers.roamer.spring.cloud.config.server.web.controller.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    public void send() {
        String msg = " hello rabbitmq , 来着 rabbitmq 的消息 ，: "+new Date();
        log.debug("Sender:"+msg);
        this.rabbitTemplate.convertAndSend("hello", msg);
    }
}
