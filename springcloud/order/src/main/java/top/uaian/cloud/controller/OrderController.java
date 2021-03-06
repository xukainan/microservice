package top.uaian.cloud.controller;

import cn.hutool.core.util.StrUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.uaian.cloud.MessageProviderService;
import top.uaian.cloud.base.BaseResult;
import top.uaian.cloud.listener.ServiceInfoListener;
import top.uaian.cloud.order.Order;

import java.util.*;

/**
 * description:  <br>
 * date: 2020/8/18 10:29 <br>
 * @author: xukainan <br>
 * version: 1.0 <br>
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    MessageProviderService messageProviderService;

    @GetMapping("/listOrdersByUserCode")
    @HystrixCommand(fallbackMethod = "listOrdersByUid_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public BaseResult<List<Order>> listOrdersByUid(@RequestParam("usercode") String usercode){
        if(StrUtil.isBlank(usercode)){
            throw new RuntimeException("usercode 为空");
        }
        System.out.println("请求的端口为：" + ServiceInfoListener.getPort());
        BaseResult<List<Order>> baseResult= new BaseResult<>();
        Map<String, List<Order>> datas = new HashMap<String, List<Order>>();
        Order order1 = new Order(1, UUID.randomUUID().toString().replaceAll("-",""), "冰箱", new Date());
        Order order2 = new Order(1, UUID.randomUUID().toString().replaceAll("-",""), "玉米", new Date());
        List<Order> list1 = new ArrayList<Order>();
        list1.add(order1);
        List<Order> list2 = new ArrayList<Order>();
        list2.add(order2);
        datas.put("00001", list1);
        datas.put("00002", list2);
//        //模拟超时
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return baseResult.renderSuccess(datas.get(usercode));
    }

    @GetMapping("/sendMsg")
    public String sendMsg(@RequestParam("msg") String msg){
        return messageProviderService.sendMessage(msg);
    }

    public BaseResult<List<Order>> listOrdersByUid_fallback(String usercode){
        return new BaseResult().renderError(400, "熔断！");
    }
}
