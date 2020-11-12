package top.uaian.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * description:  <br>
 * date: 2020/11/12 13:51 <br>
 * author: xukainan <br>
 * version: 1.0 <br>
 */
@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${service.url.nacos-order-provider}")
    private String service;

    @GetMapping("/getNacosOrder")
    public String getNacosOrder(@RequestParam Integer id){
        String forObject = restTemplate.getForObject(service + "/getNacosOrder?id=" + id, String.class);
        return forObject;
    }
}
