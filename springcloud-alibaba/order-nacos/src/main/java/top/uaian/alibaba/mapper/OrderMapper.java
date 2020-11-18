package top.uaian.alibaba.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.uaian.alibaba.model.Order;

/**
 * description:  <br>
 * date: 2020/11/18 11:39 <br>
 * author: xukainan <br>
 * version: 1.0 <br>
 */
@Mapper
public interface OrderMapper {

    int insertOrder(Order order);
}
