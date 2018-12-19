/**
 * @program: resilience4j
 * @description:
 * @author: roamer-徐泽宇
 * @create: 2018-12-19 09:17
 **/

package pers.roamer.spring.cloud.hystrix.circuitbreaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HystrixCircuitbreakerFeignClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixCircuitbreakerFeignClientApplication.class, args);
    }
}
