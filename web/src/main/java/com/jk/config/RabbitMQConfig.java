package com.jk.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue logQueue(){
        return new Queue("log-queue");
    }
    @Bean
    public FanoutExchange  fanoutExchange(){
      return new FanoutExchange("fanoutExchange");
    }
    @Bean
    public Binding bindingAckQueue2Exchange(Queue logquere,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(logquere).to(fanoutExchange);
    }
}
