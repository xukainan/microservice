package top.uaian.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
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
public class UserOrderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/listOrders")
    public BaseResult<List<Order>> listUserOrders(@RequestParam("usercode") String usercode){
        BaseResult<List<Order>> baseResult = new BaseResult<List<Order>>();
        BaseResult forObject = this.restTemplate.getForObject(Constants.ORDER_SERVICE + "/order/listOrdersByUserCode" +
                        "?usercode=" + usercode,
                BaseResult.class);
        return forObject;
    }

}
