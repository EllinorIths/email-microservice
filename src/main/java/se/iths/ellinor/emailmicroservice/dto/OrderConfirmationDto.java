package se.iths.ellinor.emailmicroservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderConfirmationDto(
        String customerEmail,
        Long id,
        List<OrderItemDto> items,
        BigDecimal totalPrice,
        LocalDateTime orderDate
) {
}
