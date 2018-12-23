/**
 * @program: demo
 * @description:
 * @author: roamer-徐泽宇
 * @create: 2018-12-21 14:17
 **/

package pers.roamer.spring.cloud.config.server.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class DemoController {

    @Value("${foo.foo-version}")
    String fooVersion ;

    @GetMapping("/showFooVersion")
    public String home() {
        return "show foo version is "  + fooVersion ;
    }
}
