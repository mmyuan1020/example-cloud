package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrixDashboard
@EnableCircuitBreaker
public class ConsumerHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerHystrixDashboardApplication.class, args);
	}
	
	/*
	@SuppressWarnings("rawtypes")
	@Bean
	public ServletRegistrationBean getServlet(){

	   HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();

	   ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);

	   registrationBean.setLoadOnStartup(1);

	   registrationBean.addUrlMappings("/actuator/hystrix.stream");

	   registrationBean.setName("HystrixMetricsStreamServlet");


	   return registrationBean;
	}
	*/
	
}
