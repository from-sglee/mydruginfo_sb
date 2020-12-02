package com.mydruginfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mydruginfo.model.InsuranceCovered;
import com.mydruginfo.service.InsuranceCoveredService;

@Controller
public class InsuranceCoveredController {

	@Autowired
	InsuranceCoveredService service;
	
	@ResponseBody
	@RequestMapping("/getInsuranceInfoByPCode/{p_code}")
	public ModelAndView getInsuranceInfoByPCode(@PathVariable("p_code") String p_code) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		Map<String, Object> map = new HashMap<>();
		
		InsuranceCovered iInfoVO = service.getInsuranceInfoByPCode(p_code);
		
		modelAndView.setViewName("page/insuranceCovered");
		map.put("function", "getInsuranceInfoByPCode");
		map.put("iInfoVO", iInfoVO);
		modelAndView.addObject("data", map);
		
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/ajaxInsurance/{p_code}")
    public Map<String, Object> jsonICovered(@PathVariable("p_code") String p_code) throws Exception {
        List<InsuranceCovered> resultList =new ArrayList<InsuranceCovered>();
        String resultText = "";

		InsuranceCovered iInfoVO = service.getInsuranceInfoByPCode(p_code);
		
		
/*
        JSONObject obj = new JSONObject();
        obj.put("name", "tychejin.tistory.com");
        obj.put("age", 2019);
        obj.put("content", iInfoVO);
        
        
        result.add(iInfoVO);
        
        return result;
*/
		if(iInfoVO!=null) {
			resultText = "success";
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("content", iInfoVO);
		map.put("result", resultText);
		
		return map;
    }
}
