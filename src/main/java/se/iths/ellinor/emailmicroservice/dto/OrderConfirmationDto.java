package se.iths.ellinor.emailmicroservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderConfirmationDto(
        String customerName,
        Long id,
        List<OrderItemDto> items,
        BigDecimal lineTotal,
        BigDecimal totalPrice,
        LocalDateTime orderDate
) {
}
