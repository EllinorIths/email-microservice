package se.iths.ellinor.emailmicroservice.dto;

import java.math.BigDecimal;

public record OrderItemDto(
        String productName,
        int quantity,
        BigDecimal price
) {
}
