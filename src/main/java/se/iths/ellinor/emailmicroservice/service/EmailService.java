package se.iths.ellinor.emailmicroservice.service;

import org.springframework.stereotype.Service;
import se.iths.ellinor.emailmicroservice.dto.OrderConfirmationDto;
import se.iths.ellinor.emailmicroservice.dto.OrderItemDto;

@Service
public class EmailService {

    public void sendOrderConfirmation(OrderConfirmationDto message) {
        String body = buildEmailBody(message);
    }

    private String buildEmailBody(OrderConfirmationDto message) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Tack för din beställning!\n\n");

        for (OrderItemDto item : message.items()) {
            stringBuilder.append(item.productName())
                    .append(" x ")
                    .append(item.quantity())
                    .append(" - ")
                    .append(item.price())
                    .append("\n");
        }

        stringBuilder.append("\nTotal: ")
                .append(message.totalPrice());
        return stringBuilder.toString();
    }
}
