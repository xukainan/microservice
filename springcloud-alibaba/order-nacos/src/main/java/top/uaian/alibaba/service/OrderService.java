package top.uaian.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "nacos-user-consumer")
@Component
public interface OrderService {

     @GetMapping("/minusMoney")
     int minusMoney(@RequestParam("money") double money, @RequestParam("userid") int userid);
}
