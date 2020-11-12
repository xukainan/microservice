package top.uaian.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * description:  <br>
 * date: 2020/11/12 9:41 <br>
 * author: xukainan <br>
 * version: 1.0 <br>
 */
@EnableBinding(Source.class)
public class MessageProviderServiceImpl implements MessageProviderService{

    @Resource
    private MessageChannel output;


    @Override
    public String sendMessage(String msg) {
        String serial = UUID.randomUUID().toString().replaceAll("-","");
        output.send(MessageBuilder.withPayload(serial).build());
        return "发送成功";
    }
}
