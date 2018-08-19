package com.example.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {
	private static String username = ActiveMQConnectionFactory.DEFAULT_USER;
	private static String password = ActiveMQConnectionFactory.DEFAULT_PASSWORD;
	private static String url = ActiveMQConnectionFactory.DEFAULT_BROKER_URL;
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory;
		Connection connection = null;
		Session session = null;
		Queue destination;

		try {
			connectionFactory = new ActiveMQConnectionFactory(username, password, url);
			connection = connectionFactory.createConnection();

			/**
			 * <pre>
			 * 参数1：事务 参数2： 
			 * 消息确认模式
			 *  AUTO_ACKNOWLEDGE 自动签收 
			 *  CLIENT_ACKNOWLEDGE  客户端自行调用ACKNOWLEDGE方法签收 
			 *  DUPS_OK_ACKNOWLEDGE 不是必须签收，消息有可能重复发送
			 * <pre>
			 */
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("que1");

			MessageProducer producer = session.createProducer(destination);

			for (int i = 0; i < 10; i++) {
				TextMessage msg = session.createTextMessage("哈哈" + i);
				producer.send(msg);
			}

			session.commit();
		} catch (Exception e) {
			if (session != null) {
				try {
					session.rollback();
				} catch (JMSException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if(connection!=null) {
					connection.close();
				}
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
}
