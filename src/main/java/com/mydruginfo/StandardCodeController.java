package com.mydruginfo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mydruginfo.model.StandardCode;
import com.mydruginfo.service.StandardCodeService;


@Controller
public class StandardCodeController {

	@Autowired
	StandardCodeService service;
	
	@ResponseBody
	@RequestMapping("/getSCodeBySCode")
	public ModelAndView getSCodeBySCode(@RequestParam String s_code) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		Map<String, Object> map = new HashMap<>();
		
		StandardCode sCodeVO = service.getStandardCodeBySCode(Long.parseLong(s_code));
		
		modelAndView.setViewName("page/standardCode");
		System.out.println(">> getStandardCodeBySCode : {" + s_code + "} : " + sCodeVO.toString());
		
		map.put("function", "getScodeBySCode");
		map.put("sCodeVO", sCodeVO);
		modelAndView.addObject("data", map);
		//modelAndView.addObject("sCodeVO", sCodeVO);
		
		return modelAndView;
	}
}
