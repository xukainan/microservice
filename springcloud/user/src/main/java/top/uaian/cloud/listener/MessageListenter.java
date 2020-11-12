package top.uaian.cloud.listener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * description:  <br>
 * date: 2020/11/12 11:39 <br>
 * author: xukainan <br>
 * version: 1.0 <br>
 */
@Component
@EnableBinding(Sink.class)
public class MessageListenter {

    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void messageListenter(Message<String> message){
        System.out.println(message.getPayload() + ":" + port);
    }
}
