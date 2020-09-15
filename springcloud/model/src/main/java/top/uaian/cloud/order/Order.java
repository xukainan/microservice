package top.uaian.cloud.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * description:  <br>
 * date: 2020/8/18 9:51 <br>
 * @author: xukainan <br>
 * version: 1.0 <br>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;
    private String ordercode;
    private String orderItem;
    private Date ordertime;
}
