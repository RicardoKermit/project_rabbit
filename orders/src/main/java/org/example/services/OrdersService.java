package org.example.services;

import org.example.config.MQConfig;
import org.example.messages.OrderConfirmationMessage;
import org.example.models.ShoppingCart;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class OrdersService {

    @Autowired
    private RabbitTemplate template;

    public void orderConfirmation(ShoppingCart shoppingCart) {

        OrderConfirmationMessage message;

        message=new OrderConfirmationMessage();
        message.setOrderNumber(shoppingCart.getNumber());
        message.setCustomerVAT(shoppingCart.getCustomerVAT());
        message.setAmount(shoppingCart.getAmount());
        message.setMessageDate(Date.from(Instant.now()));

        template.convertAndSend(
                MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY,
                message
        );
    }

}
