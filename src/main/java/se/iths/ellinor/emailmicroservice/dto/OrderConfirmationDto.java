package se.iths.ellinor.emailmicroservice.dto;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmationDto(
        String customerEmail,
        List<OrderItemDto> items,
        BigDecimal totalPrice
) {
}
