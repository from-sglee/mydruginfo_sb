package com.mydruginfo;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mydruginfo.model.StandardCode;
import com.mydruginfo.paging.Pagination;
import com.mydruginfo.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	AdminService service;
	
	@RequestMapping("/adminpage")
	public ModelAndView adminpage(@RequestParam(defaultValue="1") int page, HttpSession session) {
		
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(session.getAttribute("admin_id") == null) {
			
			modelAndView.setViewName("page/login");
			
			return modelAndView;
		}
		
		else {
			
			int totalListCnt = service.findAllCnt();
			
			Pagination pagination = new Pagination(totalListCnt, page);
			
			int startIndex = pagination.getStartIndex();
			int pageSize = pagination.getPageSize();
			
			List<StandardCode> list = service.AllStandardCode(startIndex, pageSize);
			
			
			modelAndView.addObject("List", list);
			modelAndView.addObject("pagination", pagination);
			modelAndView.setViewName("page/adminpage");
			
			return modelAndView;
			
		}
		
		
	}

}
