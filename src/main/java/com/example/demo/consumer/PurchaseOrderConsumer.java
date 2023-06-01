package com.example.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.model.OrderStatus;



@Component
public class PurchaseOrderConsumer {
	
	@Value("${ust.rabbitmq.queue}")
	String ust_queue;
	
	
	//@RabbitListener(queues = MessagingConfig.QUEUE)
	//@RabbitListener(queues = MessagingConfig.queueName)
	@RabbitListener(queues = "ust_queue")
	public void ConsumeMessageFromQueue(OrderStatus orderstatus) {
		System.out.println("Message received from queue : " + orderstatus);
	}

}