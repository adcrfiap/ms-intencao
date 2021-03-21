package br.com.fiap.arremate.msintensao.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class ExchangeConfig {

    private final Queue queue;

    @Bean
    public Exchange directExchange() {
        return ExchangeBuilder
                .directExchange("arremate.exchange")
                .build();
    }

    @Bean
    public Binding bindingQueueA() {
        return BindingBuilder
                .bind(queue)
                .to(directExchange())
                .with("arremate.routingkey")
                .noargs();
    }
}
