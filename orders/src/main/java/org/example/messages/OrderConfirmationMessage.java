package org.example.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderConfirmationMessage {
    private int orderNumber;
    private String customerVAT;
    private float amount;
    private Date messageDate;
}
