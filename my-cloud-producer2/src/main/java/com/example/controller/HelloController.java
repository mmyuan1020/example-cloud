package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping("/hello")
	public String hello(@RequestParam String name) {
		return "hello " + name + "，this is second messge, 这是服务提供者2，请刷新浏览器是否有自动负载均衡";
	}
}
