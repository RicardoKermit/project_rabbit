package org.example.listeners;

import org.example.config.MQConfig;
import org.example.messages.OrderConfirmationMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConfirmationListener {

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(OrderConfirmationMessage message) {
        System.out.println(
                "order numer: "+message.getOrderNumber()+ ", "+
                        "customer VAT: "+ message.getCustomerVAT() + ", "+
                        "amount: "+ message.getAmount()+ ", "+
                        "message date: "+ message.getMessageDate()
        );
    }
}
