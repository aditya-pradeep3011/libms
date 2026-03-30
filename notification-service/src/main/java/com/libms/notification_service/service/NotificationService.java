package com.libms.notification_service.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.libms.common_events.event.OrderPlacedEvent;

import jakarta.mail.Message.RecipientType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService 
{
	
	private final JavaMailSender mailSender;
	
	@KafkaListener(topics = "order-placed")
	public void sendEmail(ConsumerRecord<String, OrderPlacedEvent> record)
	{
		log.info("Preparing email...");
		OrderPlacedEvent orderPlacedEvent = record.value();
		MimeMessagePreparator messagePreparator = mimeMessage -> {
			mimeMessage.setFrom("libms@example.com");
			mimeMessage.setRecipients(RecipientType.TO, orderPlacedEvent.getUserEmail().toString());
			mimeMessage.setSubject("Order Confirmation");
			mimeMessage.setText(String.format(
					"""
							Dear %s %s,
							
							Thank you for your order! Your order has been successfully placed.
							
							Order Details:
							Order ID: %s
							Book Title: %s
							
							We will notify you once your order is shipped.
							
							Best regards,
							LibMS Team
					"""
					, orderPlacedEvent.getUserFirstName(), orderPlacedEvent.getUserLastName(), orderPlacedEvent.getOrderId(), orderPlacedEvent.getBookName())
			);
		};
		
		try {
			mailSender.send(messagePreparator);
			log.info("Email sent successfully");
		} catch (MailException e) {
			log.error("Failed to send email: {}", e.getMessage());
			throw new RuntimeException("Failed to send email", e);
		}
		
	}
	
//	@KafkaListener(topics = "order-placed")
//	public void debug(Object obj)
//	{
//		log.info("Received OrderPlacedEvent: {}", obj);
//		log.info(obj.getClass().getName());
//	}
}
