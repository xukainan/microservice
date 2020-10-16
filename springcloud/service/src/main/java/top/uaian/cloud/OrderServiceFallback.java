package top.uaian.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.uaian.cloud.base.BaseResult;
import top.uaian.cloud.order.Order;

import java.util.List;

/**
 * description:  <br>
 * date: 2020/10/16 13:38 <br>
 * author: xukainan <br>
 * version: 1.0 <br>
 */
@Slf4j
@Component
public class OrderServiceFallback implements OrderService {
    @Override
    public BaseResult<List<Order>> listUserOrders(String usercode) {
        log.info("请求超时");
        return null;
    }
}
