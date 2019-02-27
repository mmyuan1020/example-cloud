package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping("/hello")
	public String hello(@RequestParam String name) {
		logger.info("my-cloud-producer2: --> request two name is " + name);
/* 为了开启 zuul的retry功能		
		try {
			Thread.sleep(1000000);
		} catch (Exception e) {
			logger.error(" hello two error", e);
		}
*/
		return "hello " + name + "，this is second messge, 这是服务提供者2，请刷新浏览器是否有自动负载均衡";
	}
}
