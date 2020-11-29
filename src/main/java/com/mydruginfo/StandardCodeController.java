package com.mydruginfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mydruginfo.model.StandardCode;
import com.mydruginfo.paging.Pagination;
import com.mydruginfo.service.StandardCodeService;

@Controller
public class StandardCodeController {

	@Autowired
	StandardCodeService service;

	@ResponseBody
	@RequestMapping("/drug-info/{s_code}")
	public ModelAndView getSCodeBySCode(@PathVariable("s_code") String s_code, HttpServletResponse response) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		Map<String, Object> map = new HashMap<>();
		
		StandardCode sCodeVO = service.getStandardCodeBySCode(Long.parseLong(s_code));
		
		if(sCodeVO==null) {
			System.out.println(">> getSCodeBySCode > sCodeVO is Empty");
			//response.setContentType("text/html; charset=utf-8");
			//PrintWriter out = response.getWriter();
			//out.println("<script>alert('잘못된 요청입니다.');</script>");
			modelAndView.setViewName("redirect:/");
		}else {
			System.out.println(">> getSCodeBySCode > sCodeVO.drug_name = " + sCodeVO.getDrug_name_kr());
			map.put("function", "getScodeBySCode");
			map.put("sCode", sCodeVO);
			modelAndView.addObject("data", map);
			modelAndView.setViewName("page/standardCode");
		}
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/drug-search")
	public ModelAndView getSCodeSearch(@RequestParam  String type, String searchTxt, @RequestParam(defaultValue="1") String page) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		Map<String, Object> map = new HashMap<>();
		String searchType = "";
		int intPage = 1;
		
		try{
			if(!page.isEmpty()) {
				intPage = Integer.parseInt(page);
			}
		}catch (Exception e) {
			//
		}
		
		if(type.equals("drug"))
			searchType = "drug_name_kr";
		else if(type.equals("company"))
			searchType = "company_name";
		else if(!type.equals("atc_code") && !type.equals("product_code"))
			searchType = "";

		if(type==null || searchType.equals("")) {
			System.out.println(">> /drug-search > The value of the 'type' variable is invalid.");
			modelAndView.setViewName("redirect:/");
			return modelAndView;
		}
		
		int totalListCnt = service.getCountLikeColumn(searchType, searchTxt);
		if(totalListCnt > 0) {
			Pagination pagination = new Pagination(totalListCnt, intPage);
			int startIndex = pagination.getStartIndex();
			int pageSize = pagination.getPageSize();
			List<StandardCode> sCodeList = service.getStandardCodeLikeColumn(searchType, searchTxt, startIndex, pageSize);
			modelAndView.addObject("type", type);
			modelAndView.addObject("searchTxt", searchTxt);
			modelAndView.addObject("sCodeList", sCodeList);
			modelAndView.addObject("pagination", pagination);
			modelAndView.setViewName("page/standardCodeList");
		}else {
			map.put("function", "getScodeLikeCName");
			map.put("list", "empty");
			modelAndView.addObject("data", map);
			modelAndView.setViewName("page/standardCodeList");
			
		}
		
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/all-drug-list/{page}")
	public ModelAndView getAllSCodeList(@PathVariable("page") String page) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		Map<String, Object> map = new HashMap<>();
		int intPage		= 0;
		int intPerPage	= 10;
		try {
			if(!page.isEmpty()) {
				intPage = Integer.parseInt(page);
			}
		} catch (Exception e) {
			
		}
		int totalListCnt = service.getCountAllStandardCode();
		System.out.println(">> getCountAllSCode(allListSize) = "+totalListCnt);
		
		if(totalListCnt > 0) {
			Pagination pagination = new Pagination(totalListCnt, intPage);
			int startIndex = pagination.getStartIndex();
			int pageSize = pagination.getPageSize();
			List<StandardCode> sCodeList = service.getAllStandardCode(startIndex, pageSize);
			modelAndView.addObject("sCodeList", sCodeList);
			modelAndView.addObject("pagination", pagination);
			modelAndView.setViewName("page/standardCodeList");
		}else {
			map.put("function", "getAllSCodeList");
			map.put("list", "empty");
			modelAndView.addObject("data", map);
			modelAndView.setViewName("page/standardCodeList");
		}
		map = null;
		return modelAndView;
	}
	

}
