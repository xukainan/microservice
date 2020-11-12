package top.uaian.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:  <br>
 * date: 2020/11/12 13:58 <br>
 * author: xukainan <br>
 * version: 1.0 <br>
 */
@RestController
public class OrderController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/getNacosOrder")
    public String getNacosOrder(@RequestParam Integer id){
        return port;
    }
}
