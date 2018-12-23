/**
 * @program: demo
 * @description:
 * @author: roamer-徐泽宇
 * @create: 2018-12-23 21:48
 **/

package pers.roamer.spring.cloud.eureka.client.web.controller.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RabbitListener(queues = "hello")
public class Receiver {

    @RabbitHandler
    public void process(@Payload String msg) {
        log.debug("Receiver:"+msg);
    }
}
