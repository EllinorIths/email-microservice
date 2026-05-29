package se.iths.ellinor.emailmicroservice.subscriber;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import se.iths.ellinor.emailmicroservice.config.RabbitConfig;
import se.iths.ellinor.emailmicroservice.dto.OrderConfirmationDto;
import se.iths.ellinor.emailmicroservice.service.EmailService;

@Component
@RequiredArgsConstructor
public class OrderEmailSubscriber {

    private final EmailService emailService;

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void subscribe(OrderConfirmationDto message) {
        try {
            emailService.sendOrderConfirmation(message);


        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("MESSAGE RECEIVED: " + message);
    }
}
