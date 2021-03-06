package top.uaian.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserConsulApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserConsulApplication.class, args);
    }

}
