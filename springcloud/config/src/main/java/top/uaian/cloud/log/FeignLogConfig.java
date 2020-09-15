package top.uaian.cloud.log;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description:  <br>
 * date: 2020/9/15 17:14 <br>
 * author: xukainan <br>
 * version: 1.0 <br>
 */
@Configuration
public class FeignLogConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
