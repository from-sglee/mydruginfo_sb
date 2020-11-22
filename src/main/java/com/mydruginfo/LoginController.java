package com.mydruginfo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@ResponseBody
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		Map<String, Object> map = new HashMap<>();

		System.out.println("loginController");
		map.put("message", " :: Login");
		
		modelAndView.addObject("data", map);
		modelAndView.setViewName("page/login");
		
		return modelAndView;
	}

}
