package top.uaian.alibaba.controller;

import com.alibaba.csp.sentinel.adapter.spring.webflux.exception.SentinelBlockExceptionHandler;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.uaian.alibaba.mapper.UserMapper;
import top.uaian.alibaba.model.User;

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
    @Autowired
    UserMapper userMapper;

    @Value("${service.url.nacos-order-provider}")
    private String service;

    @GetMapping("/getNacosOrder")
    public String getNacosOrder(@RequestParam Integer id){
        String forObject = restTemplate.getForObject(service + "/getNacosOrder?id=" + id, String.class);
        return forObject;
    }


    @GetMapping("/getSentinel")
    @SentinelResource(value = "getSentinel", blockHandler = "dealSentinelHandler", fallback = "fallback",
            exceptionsToIgnore = {InterruptedException.class})
    public String getSentinbel(){
        return "getSentinel";
    }

    public String dealSentinelHandler(BlockException ex){
        return "dealSentinelHandler:" + ex.getMessage();
    }


    public String fallback(Throwable throwable){
        return "fallback:" + throwable.getMessage();
    }


    @GetMapping("/getUser/{id}")
    public String getUser(@PathVariable int id){
        User user = userMapper.selectOne(id);
        return  user.toString();
    }

    @GetMapping("/minusMoney")
    public int minusMoney(@RequestParam double money, @RequestParam int userid){
        int i = userMapper.minusMoney(userid, money);
//        i = 1/0;
        return i;
    }
}
