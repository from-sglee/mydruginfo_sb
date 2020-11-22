package com.mydruginfo;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController{
	
	@ResponseBody
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("page/home");
		
		Map<String, Object> map = new HashMap<>();
		modelAndView.addObject("data", map);
		
		return modelAndView;
	}

}