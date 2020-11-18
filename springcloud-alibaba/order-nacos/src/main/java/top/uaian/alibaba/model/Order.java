package top.uaian.alibaba.model;

import lombok.Data;

/**
 * description:  <br>
 * date: 2020/11/18 9:24 <br>
 * author: xukainan <br>
 * version: 1.0 <br>
 */
@Data
public class Order {
    private int id;
    private String code;
    private String product;
    private int userId;
    private double money;
}
