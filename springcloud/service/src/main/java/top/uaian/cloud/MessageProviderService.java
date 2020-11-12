package top.uaian.cloud;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

/**
 * description:  <br>
 * date: 2020/11/12 9:41 <br>
 * author: xukainan <br>
 * version: 1.0 <br>
 */
public interface MessageProviderService {

    String sendMessage(String msg);
}
