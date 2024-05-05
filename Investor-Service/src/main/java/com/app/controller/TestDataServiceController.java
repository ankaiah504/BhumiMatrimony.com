package com.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope
@RestController
@RequestMapping("/test")

public class TestDataServiceController {

	   @Value("${msg:Hello default}")
	private String msgTxt;
	@GetMapping("/welcome")
	public String getMsg() {
		
		return this.msgTxt;
	}
}
