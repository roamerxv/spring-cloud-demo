/**
 * @program: client
 * @description:
 * @author: roamer-徐泽宇
 * @create: 2018-11-09 17:54
 **/

package pers.roamer.spring.cloud.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession
@EnableEurekaClient
public class HiServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run( HiServiceApplication.class, args );
    }

}
