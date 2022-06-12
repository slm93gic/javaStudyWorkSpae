package rabbitmq.ttl;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import rabbitmq.RabbitMqUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 消费者
 * 死信
 */
@SuppressWarnings("all")
public class TTlConsumer1 {

    //正常交换机
    public static final String NORMAL_EXCHANGE = "normal_exchang";
    //死信交换机
    public static final String DEAD_EXCHANGE = "dead_exchange";
    //普通队列名称
    public static final String NORMAL_QUEUE = "normal_queue";
    //死信队列名称
    public static final String DEAD_QUEUE = "dead_queue";

    public static void main(String[] args) throws Exception {
        //获取信道
        Channel channel = RabbitMqUtils.getChannel();
        //死信和正常交换机模式
        channel.exchangeDeclare(NORMAL_EXCHANGE, BuiltinExchangeType.DIRECT);
        channel.exchangeDeclare(DEAD_EXCHANGE, BuiltinExchangeType.DIRECT);
        //创建普通队列 在普通队列中的消息异常后转发到死信对垒
        Map<String, Object> map = new HashMap<>();
        //可以不写。可以在生产着那边设置发送的过期时间
//        map.put("x-message-ttl", 10 * 1000);//10秒
        //过期时间
        map.put("x-dead-letter-exchange", DEAD_EXCHANGE);
        //设置routingKey
        map.put("x-dead-letter-routing-key", "lisi");
        channel.queueDeclare(NORMAL_QUEUE, false, false, false, map);
        //创建普通队列
        channel.queueDeclare(DEAD_QUEUE, false, false, false, null);
        //绑定
        channel.queueBind(NORMAL_QUEUE, NORMAL_EXCHANGE, "zhangsan");
        channel.queueBind(DEAD_QUEUE, DEAD_EXCHANGE, "lisi");

        //回调接口
        DeliverCallback deliverCallback = (consumberTag, message) -> {
            System.out.println("正常消息的消费: " + new String(message.getBody()));
        };
        channel.basicConsume(NORMAL_QUEUE, true, deliverCallback, (consumberTag) -> {
        });


    }

}
