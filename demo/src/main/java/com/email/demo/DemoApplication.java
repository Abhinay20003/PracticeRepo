package com.email.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.email.demo.model.User;
import com.email.demo.service.UserRegisteredEvent;

@SpringBootApplication
public class DemoApplication {
	@Autowired
	private JavaMailSender mailSender;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	 @EventListener(UserRegisteredEvent.class) // Listen to UserRegisteredEvent
	    public void sendRegistrationEmail(UserRegisteredEvent event) {
	        User user = event.getUser();
	        String toEmail = user.getEmail();
	        String subject = "Welcome to our E-Comm Application";
	        String body = "Dear " + user.getEmail() + ",\n\nWelcome to our SHELBY APPLICATION. Thank you for Registering.";
	        sendEmail(toEmail, subject, body);
	    }

	public void sendEmail(String toEmail, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("18891a05e8.abhinaykumar@gmail.com");
		message.setTo(toEmail);
		message.setSubject(subject);
		message.setText(body);

		mailSender.send(message);
		System.out.println("Mail Sent to registered user");
	}
}
