package top.uaian.cloud.conf;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * description:  <br>
 * date: 2020/10/21 14:15 <br>
 * author: xukainan <br>
 * version: 1.0 <br>
 */
@Component
public class RoutesConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("EUREKA-CLIENT-CONSUMER-USER", r -> r.path("/user/**")
                                .uri("http://localhost:8070")).build();
    }

}
