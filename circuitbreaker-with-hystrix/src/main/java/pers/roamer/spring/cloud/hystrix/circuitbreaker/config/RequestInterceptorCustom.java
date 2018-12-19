/**
 * @program: demo
 * @description:
 * @author: roamer-徐泽宇
 * @create: 2018-12-19 16:22
 **/

package pers.roamer.spring.cloud.hystrix.circuitbreaker.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Retryer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import static java.util.concurrent.TimeUnit.SECONDS;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Configuration
@Slf4j
public class RequestInterceptorCustom implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        log.debug("MyRequestInterceptor apply begin.");

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            log.debug("requestAttributes is null");
            return;
        }
        log.debug("requestAttributes is not null");
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                Enumeration<String> values = request.getHeaders(name);
                while (values.hasMoreElements()) {
                    String value = values.nextElement();
                    log.debug("\t header name is {}, value is  {}",name,value);
                    requestTemplate.header(name, value);
                }
            }
        }
    }

    @Bean
    public Retryer feignRetryer(){
        return new Retryer.Default(500,SECONDS.toMillis(1),5);
    }

    @Bean
    public FeignHystrixConcurrencyStrategy feignHystrixConcurrencyStrategy() {
        return new FeignHystrixConcurrencyStrategy();
    }
}
