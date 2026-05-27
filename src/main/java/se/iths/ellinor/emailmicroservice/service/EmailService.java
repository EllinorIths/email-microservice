package se.iths.ellinor.emailmicroservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.iths.ellinor.emailmicroservice.dto.OrderConfirmationDto;
import se.iths.ellinor.emailmicroservice.dto.OrderItemDto;
import se.iths.johan.springmessenger.model.Email;
import se.iths.johan.springmessenger.service.MessageService;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final MessageService messageService;

    public void sendOrderConfirmation(OrderConfirmationDto message) {

        String body = buildEmailBody(message);
        Email email = new Email();

        email.setRecipient(message.customerEmail());
        email.setSubject("Orderbekräftelse");
        email.setMessage(body);

        messageService.send(email);
    }

    private String buildEmailBody(OrderConfirmationDto message) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Tack för din beställning!\n\n")
                .append("Ordernummer: " + message.id()).append("\n")
                .append("Email: " + message.customerEmail()).append("\n")
                .append("Datum: " + message.orderDate()).append("\n\n");

        for (OrderItemDto item : message.items()) {
            BigDecimal itemTotal =
                    item.price().multiply(BigDecimal.valueOf(item.quantity()));

            stringBuilder.append(item.productName())
                    .append(" x ")
                    .append(item.quantity())
                    .append(" - ")
                    .append(item.price())
                    .append(" kr/st = ")
                    .append(itemTotal)
                    .append(" kr")
                    .append("\n");
        }

        stringBuilder.append("\nTotalt: ")
                .append(message.totalPrice())
                .append(" kr");

        return stringBuilder.toString();
    }
}