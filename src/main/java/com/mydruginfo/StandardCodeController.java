package com.mydruginfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	@RequestMapping("/getSCodeBySCode")
	public ModelAndView getSCodeBySCode(@RequestParam String s_code, HttpServletResponse response) throws Exception{
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
	@RequestMapping("/search")
	public ModelAndView getSCodeSearch(@RequestParam  String type, String searchTxt, @RequestParam(defaultValue="1") String page) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		Map<String, Object> map = new HashMap<>();
		int intPage = 1;
		
		try{
			if(!page.isEmpty()) {
				intPage = Integer.parseInt(page);
			}
		}catch (Exception e) {
			//
		}
		int totalListCnt = service.getCountLikeColumn(type, searchTxt);
		if(totalListCnt > 0) {
			Pagination pagination = new Pagination(totalListCnt, intPage);
			int startIndex = pagination.getStartIndex();
			int pageSize = pagination.getPageSize();
			List<StandardCode> sCodeList = service.getStandardCodeLikeColumn(type, searchTxt, startIndex, pageSize);
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
	@RequestMapping("/getAllSCodeList")
	public ModelAndView getAllSCodeList(@RequestParam String page, String perPage, String pageSize) throws Exception{
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
		int allListSize = service.getCountAllStandardCode();
		System.out.println(">> getCountAllSCode(allListSize) = "+allListSize);
		//PageInfo page = new(pageNo, perPage, pageSize, listSize);
		List<StandardCode> sCodeList = service.getAllStandardCode(intPage, intPerPage);
		if(sCodeList.size()>0) {
			int lastPage =  (int) Math.ceil(allListSize / intPerPage);
			int pageBlockSize = 10;
			int pageBlockNo = (int) Math.floor((intPage-1) / pageBlockSize);
			int pageBlockMin = 1;
			int pageBlockMax = 10;
			int prevPage = 0;
			int nextPage = 0;
			
			if(intPage > pageBlockSize) { // page=23, block=10, 21-30
				pageBlockMin = (int) Math.floor((intPage-1) / pageBlockSize) * pageBlockSize + 1;
				pageBlockMax = ((int) Math.floor(intPage / pageBlockSize)+1) * pageBlockSize;
			}
			map.put("function", "getAllSCodeList");
			map.put("list", sCodeList);
			map.put("page", page);
			map.put("allListSize", allListSize);
			map.put("pageBlockSize", pageBlockSize);
			map.put("pageBlockNo", pageBlockNo);
			map.put("pageBlockMin", pageBlockMin);
			map.put("pageBlockMax", pageBlockMax);
			map.put("prevPage", prevPage);
			map.put("nextPage", nextPage);
			map.put("lastPage", lastPage);
			modelAndView.addObject("data", map);
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
