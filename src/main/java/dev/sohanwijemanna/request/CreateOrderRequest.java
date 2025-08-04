package dev.sohanwijemanna.request;

import dev.sohanwijemanna.model.Address;
import lombok.Data;

@Data
public class CreateOrderRequest {
    private Long restaurantId;
    private Address deliveryAddress;
}
