package se.iths.ellinor.emailmicroservice.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import se.iths.ellinor.emailmicroservice.config.RabbitConfig;
import se.iths.ellinor.emailmicroservice.dto.OrderConfirmationMessage;
import se.iths.ellinor.emailmicroservice.service.EmailService;

@Component
@RequiredArgsConstructor
public class OrderEmailConsumer {

    private final EmailService emailService;

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void receive(OrderConfirmationMessage message) {
        emailService.sendOrderConfirmation(message);
        System.out.println("MESSAGE RECIEVED: " + message);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new JacksonJsonMessageConverter();
    }

}
