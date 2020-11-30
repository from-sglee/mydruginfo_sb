package com.mydruginfo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mydruginfo.model.InsuranceCovered;
import com.mydruginfo.model.MainIngredient;
import com.mydruginfo.model.StandardCode;
import com.mydruginfo.paging.Pagination;
import com.mydruginfo.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService service;

	@RequestMapping("/adminpage")
	public ModelAndView adminpage(@RequestParam(defaultValue = "1") int page, HttpSession session,
			HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();

		if (session.getAttribute("admin_id") == null) {

			modelAndView.setViewName("page/login");

			return modelAndView;
		}

		else {

			String button_value = null;

			int totalListCnt = service.findAllCnt();

			Pagination pagination = new Pagination(totalListCnt, page);

			int startIndex = pagination.getStartIndex();
			int pageSize = pagination.getPageSize();

			List<StandardCode> list = service.AllStandardCode(startIndex, pageSize);
			button_value = "standard_code";
			modelAndView.addObject("List", list);
			modelAndView.addObject("pagination", pagination);
			modelAndView.addObject("button_value", button_value);
			modelAndView.setViewName("page/adminpage");

			return modelAndView;

		}

	}

	@RequestMapping("/adminpage_insurance_covered")
	public ModelAndView adminpageIC(@RequestParam(defaultValue = "1") int page, HttpSession session,
			HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();

		String button_value = null;
		int totalListCnt = service.findAllCnt();

		Pagination pagination = new Pagination(totalListCnt, page);

		int startIndex = pagination.getStartIndex();
		int pageSize = pagination.getPageSize();

		List<InsuranceCovered> list = service.AllInsuranceCovered(startIndex, pageSize);
		button_value = "insurance_covered";
		modelAndView.addObject("List", list);
		modelAndView.addObject("button_value", button_value);
		modelAndView.addObject("pagination", pagination);
		modelAndView.setViewName("page/adminpage");

		return modelAndView;

	}

	@RequestMapping("/adminpage_main_ingredient")
	public ModelAndView adminpageMI(@RequestParam(defaultValue = "1") int page, HttpSession session,
			HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();

		String button_value = null;

		int totalListCnt = service.findAllCnt();

		Pagination pagination = new Pagination(totalListCnt, page);

		int startIndex = pagination.getStartIndex();
		int pageSize = pagination.getPageSize();

		List<MainIngredient> list = service.AllMainIngredient(startIndex, pageSize);
		button_value = "main_ingredient";
		modelAndView.addObject("List", list);
		modelAndView.addObject("pagination", pagination);
		modelAndView.addObject("button_value", button_value);
		modelAndView.setViewName("page/adminpage");

		return modelAndView;

	}

}
