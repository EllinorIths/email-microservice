package se.iths.ellinor.emailmicroservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.iths.ellinor.emailmicroservice.dto.OrderConfirmationDto;
import se.iths.ellinor.emailmicroservice.dto.OrderItemDto;
import se.iths.johan.springmessenger.model.Email;
import se.iths.johan.springmessenger.service.MessageService;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final MessageService messageService;

    public void sendOrderConfirmation(OrderConfirmationDto message) {

        String body = buildEmailBody(message);
        Email email = new Email();

        email.setRecipient(message.customerName());
        email.setSubject("Orderbekräftelse");
        email.setMessage(body);

        System.out.println("EMAIL: " + email);

        messageService.send(email);
    }

    private String buildEmailBody(OrderConfirmationDto message) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Tack för din beställning!\n\n")
                .append("Ordernummer: " + message.id()).append("\n")
                .append("Email: " + message.customerName()).append("\n")
                .append("Datum: " + message.orderDate()).append("\n\n");

        for (OrderItemDto item : message.items()) {

            stringBuilder.append(item.name())
                    .append(" x ")
                    .append(item.quantity())
                    .append(" - ")
                    .append(item.price())
                    .append(" kr/st = ")
                    .append(item.lineTotal())
                    .append(" kr")
                    .append("\n");
        }

        stringBuilder.append("\nTotalt: ")
                .append(message.totalPrice())
                .append(" kr");

        return stringBuilder.toString();
    }
}