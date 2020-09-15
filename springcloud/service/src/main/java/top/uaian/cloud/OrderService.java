package top.uaian.cloud;

import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.uaian.cloud.base.BaseResult;
import top.uaian.cloud.order.Order;

import java.util.List;

/**
 * description:  <br>
 * date: 2020/9/15 16:54 <br>
 * author: xukainan <br>
 * version: 1.0 <br>
 */
@Component
@FeignClient(name="EUREKA-CLIENT-PRODUCER-ORDER")
public interface OrderService {

    @GetMapping("/order/listOrdersByUserCode")
    BaseResult<List<Order>> listUserOrders(@RequestParam("usercode") String usercode);
}


