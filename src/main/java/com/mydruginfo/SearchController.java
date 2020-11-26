package com.mydruginfo;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mydruginfo.model.SearchVO;
import com.mydruginfo.model.StandardCode;
import com.mydruginfo.service.SearchService;

@Controller
public class SearchController {

	@Autowired
	SearchService searchservice;

	@RequestMapping("/search")
	@ResponseBody
	public ModelAndView search(@ModelAttribute SearchVO vo, HttpServletResponse response) throws Exception {

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		ModelAndView mv = new ModelAndView();
		
		if (vo.getATC_code_search() == false && vo.getCommon_name_code_search() == false
				&& vo.getCompany_name_search() == false && vo.getDrug_name_search() == false
				&& vo.getProduct_code_search() == false) {
			mv.setViewName("page/home");
			out.println("<script>alert('체크박스를 표시해주세요.')</script>");
			out.flush();
		}

		else if (vo.getSearchText() == null) {
			mv.setViewName("page/home");
			out.println("<script>alert('검색어를 입력해주세요.')</script>");
			out.flush();
		}

		else {
			ModelAndView modelAndView = new ModelAndView();
			Map<String, Object> map = new HashMap<>();
			List<StandardCode> sCodeList = searchservice.getSearch(vo);
			mv.setViewName("page/searchPage");
			mv.addObject("message", "sCodeList here");
			mv.addObject("sCodeList",sCodeList);
		}

		return mv;
	}

}
