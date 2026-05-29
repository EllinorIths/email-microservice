package se.iths.ellinor.emailmicroservice.subscriber;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import se.iths.ellinor.emailmicroservice.config.RabbitConfig;
import se.iths.ellinor.emailmicroservice.dto.OrderConfirmationDto;
import se.iths.ellinor.emailmicroservice.service.EmailService;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderEmailSubscriber {

    private final EmailService emailService;

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void subscribe(OrderConfirmationDto message) {
        try {
            emailService.sendOrderConfirmation(message);
            log.info("Mail sent: " + message);

        } catch (Exception e) {
            e.printStackTrace();
            log.error(String.valueOf(e));
            System.out.println("Error: " + e);
        }
        System.out.println("MESSAGE RECEIVED: " + message);
    }
}
