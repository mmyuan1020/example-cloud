package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller("hello")
public class HelloController {
	@RequestMapping({"/hello","/m/hello2"})
	public String hello(@RequestParam String name) {
		return "hello " + name + "，this is first messge";
	}
}
