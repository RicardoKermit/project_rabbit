package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShoppingCart {
    private int number;
    private String customerVAT;
    private int quantity;
    private int price;
    public float getAmount(){
        return quantity * price;
    }
}
