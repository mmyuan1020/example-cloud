package com.example.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer {
	private static String username = ActiveMQConnectionFactory.DEFAULT_USER;
	private static String password = ActiveMQConnectionFactory.DEFAULT_PASSWORD;
	private static String url = ActiveMQConnectionFactory.DEFAULT_BROKER_URL;
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory;
		Connection connection = null;
		Session session = null;
		Destination destination;

		try {
			connectionFactory = new ActiveMQConnectionFactory(username, password, url);
			connection = connectionFactory.createConnection();
			connection.start(); // 消息生产者不需要此start!!

			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("que1"); // 队列名要和生产者队列名一到

			MessageConsumer  consumer = session.createConsumer(destination);

			
			while (true) {
				TextMessage message = (TextMessage)consumer.receive(10000);
				if(message!=null) {
					System.out.println(message.getText());
				} else {
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection!=null) {
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
