/**
 * @program: demo
 * @description: 提供一个测试用的 restful 调用
 * @author: roamer-徐泽宇
 * @create: 2018-12-20 19:00
 **/

package pers.roamer.spring.cloud.eureka.client.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RefreshScope
public class DemoController {
    @Autowired
    HttpSession httpSession;

    @Value("${server.port}")
    String port;

    @Value("${foo.foo-version}")
    String fooVersion ;

    final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("z时区 yyyy-MM-dd HH:mm:ss:SSS");

    @GetMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "roamer") String name) throws UnknownHostException {
        return "你好 " + name + " ,i am from port:" + port +
                ". Session id 是:"+ httpSession.getId() +
                ", host is "+ InetAddress.getLocalHost().getHostAddress() +
                "，调用时间："+ simpleDateFormat.format(new Date()) + "\n" +
                "环境变量中的变量 foo.foo-version 是 "+ fooVersion;
    }
}
