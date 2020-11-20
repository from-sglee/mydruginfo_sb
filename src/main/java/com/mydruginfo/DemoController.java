package com.mydruginfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController{
	@ResponseBody
	@RequestMapping("/")
	public String home() {
		System.out.println("Hello");
		return "Hello Boot";
	}
	
	@RequestMapping("/hello")
	public String hello(Model model) {
		System.out.println("Hello");
		model.addAttribute("message", "hello.jsp 본문 한글 출력 확인");
		return "hello";
	}
}