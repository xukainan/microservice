package top.uaian.alibaba.controller;

import com.alibaba.nacos.common.util.UuidUtils;
import com.sun.org.apache.xpath.internal.operations.Or;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.uaian.alibaba.mapper.OrderMapper;
import top.uaian.alibaba.model.Order;
import top.uaian.alibaba.service.OrderService;

/**
 * description:  <br>
 * date: 2020/11/12 13:58 <br>
 * author: xukainan <br>
 * version: 1.0 <br>
 */
@RestController
public class OrderController {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderService orderService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/getNacosOrder")
    public String getNacosOrder(@RequestParam Integer id){
        return port;
    }

    @GetMapping("/createOrder")
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public int createOrder(){
        Order order = new Order();
        order.setId(1);
        order.setCode(UuidUtils.generateUuid());
        order.setProduct("手机");
        order.setUserId(1);
        order.setMoney(9.99d);
        int i = orderMapper.insertOrder(order);
        int i1 = orderService.minusMoney(9.99d, 1);
        return i1;
    }
}
