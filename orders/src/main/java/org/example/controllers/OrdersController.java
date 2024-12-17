package org.example.controllers;

import org.example.models.ShoppingCart;
import org.example.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @PostMapping("/order-confirmation")
    public ResponseEntity<Void> orderConformation(@RequestBody ShoppingCart shoppingCart){
        ordersService.orderConfirmation(shoppingCart);
        return ResponseEntity.ok().build();
    }
}
