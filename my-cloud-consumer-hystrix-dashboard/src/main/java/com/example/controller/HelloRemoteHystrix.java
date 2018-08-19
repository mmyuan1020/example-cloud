package com.example.controller;

import org.springframework.stereotype.Component;

/**
 * 服务降级处理类
 * @author mingmin.yuan
 *
 */
@Component
public class HelloRemoteHystrix implements HelloRemote {

	@Override
	public String hello(String name) {
		return "sorry, this regards is failed, name is "+name;
	}

}
