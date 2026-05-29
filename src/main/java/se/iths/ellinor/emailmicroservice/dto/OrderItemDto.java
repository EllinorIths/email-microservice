package se.iths.ellinor.emailmicroservice.dto;

import java.math.BigDecimal;

public record OrderItemDto(
        Long productId,
        String name,
        BigDecimal price,
        int quantity,
        BigDecimal lineTotal
) {
}
