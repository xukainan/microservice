package top.uaian.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.uaian.cloud.OrderService;
import top.uaian.cloud.base.BaseResult;
import top.uaian.cloud.base.Constants;
import top.uaian.cloud.order.Order;

import java.util.List;

/**
 * description:  <br>
 * date: 2020/8/18 9:54 <br>
 * @author: xukainan <br>
 * version: 1.0 <br>
 */
@RestController
@RequestMapping("/user")
//@DefaultProperties(defaultFallback = "defaultFallbackMethod")
public class UserOrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/listOrders")
    @HystrixCommand(fallbackMethod = "timeoutMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
//    @HystrixCommand(fallbackMethod = "listUserOrders_error");
//    @HystrixCommand
    public BaseResult<List<Order>> listUserOrders(@RequestParam("usercode") String usercode){
        BaseResult<List<Order>> baseResult = new BaseResult<List<Order>>();
        baseResult = orderService.listUserOrders(usercode);
        return baseResult;
    }

    public BaseResult<List<Order>> listUserOrders_error(@RequestParam("usercode") String usercode){
        return new BaseResult().renderError(404, "查询失败！");
    }

    public BaseResult<List<Order>> defaultFallbackMethod(){
        return new BaseResult().renderError(400, "查询失败！");

    }

    public BaseResult<List<Order>> timeoutMethod(String usercode){
        return new BaseResult().renderError(400, "超时！");

    }

}
