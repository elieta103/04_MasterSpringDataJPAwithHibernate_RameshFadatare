package net.javaguides.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse {
    private String orderTackingNumber;
    private String status;
    private String message;
}
