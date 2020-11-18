package top.uaian.alibaba.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * description:  <br>
 * date: 2020/11/18 10:31 <br>
 * author: xukainan <br>
 * version: 1.0 <br>
 */
@Configuration
@MapperScan("top.uaian.alibaba.mapping")
public class MybatisConfig {
}
