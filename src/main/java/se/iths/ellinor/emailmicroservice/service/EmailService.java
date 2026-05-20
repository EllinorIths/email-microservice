package se.iths.ellinor.emailmicroservice.service;

import org.springframework.stereotype.Service;
import se.iths.ellinor.emailmicroservice.dto.OrderConfirmationMessage;
import se.iths.ellinor.emailmicroservice.dto.OrderItemDto;

@Service
public class EmailService {

    public void sendOrderConfirmation(OrderConfirmationMessage message) {
        String body = buildEmailBody(message);
    }

    private String buildEmailBody(OrderConfirmationMessage message) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Tack för din beställning!\n\n");

        for (OrderItemDto item : message.getItems()) {
            stringBuilder.append(item.getProductName())
                    .append(" x ")
                    .append(item.getQuantity())
                    .append(" - ")
                    .append(item.getPrice())
                    .append("\n");
        }

        stringBuilder.append("\nTotal: ")
                .append(message.getTotalPrice());
        return stringBuilder.toString();
    }
}
