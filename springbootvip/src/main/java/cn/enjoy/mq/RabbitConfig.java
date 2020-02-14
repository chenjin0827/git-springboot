package cn.enjoy.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Rabbit配置类，用来配置队列，交换器，路由等高级信息
 */
@Configuration
public class RabbitConfig {
    @Bean
    public Queue firstQueue() {
        // 创建一个队列，名称为：enjoy
        return new Queue("enjoy");
    }
}
