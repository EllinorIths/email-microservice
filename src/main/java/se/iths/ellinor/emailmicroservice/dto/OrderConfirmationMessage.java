package se.iths.ellinor.emailmicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderConfirmationMessage {

    private String customerEmail;

    private List<OrderItemDto> items;

    private BigDecimal totalPrice;

}
