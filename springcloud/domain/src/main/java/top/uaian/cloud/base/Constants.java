package top.uaian.cloud.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * description:  <br>
 * date: 2020/8/18 10:23 <br>
 * @author: xukainan <br>
 * version: 1.0 <br>
 */
@Component
public class Constants {

    public static String ORDER_SERVICE;

    @Value("${thirdserice-order:http://localhost:8090}")
    public void setOrderService(String orderService) {
        Constants.ORDER_SERVICE = orderService;
    }
}
