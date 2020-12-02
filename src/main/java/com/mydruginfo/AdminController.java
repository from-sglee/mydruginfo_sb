package com.mydruginfo;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mydruginfo.model.InsuranceCovered;
import com.mydruginfo.model.MainIngredient;
import com.mydruginfo.model.StandardCode;
import com.mydruginfo.paging.Pagination;
import com.mydruginfo.service.AdminService;
import com.mydruginfo.service.StandardCodeService;

@Controller
public class AdminController {

	@Autowired
	AdminService service;
	@Autowired
	StandardCodeService standardservice;

	@RequestMapping("/adminpage")
	public ModelAndView adminpage(@RequestParam(defaultValue = "1") int page, HttpSession session) {

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
	
	@RequestMapping("/adminpage_standard_code")
	public ModelAndView adminpageSC(@RequestParam(defaultValue = "1") int page, HttpSession session) {

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
	public ModelAndView adminpageIC(@RequestParam(defaultValue = "1") int page, HttpSession session) {

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
	public ModelAndView adminpageMI(@RequestParam(defaultValue = "1") int page, HttpSession session) {

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

	@ResponseBody
	@RequestMapping("/admin_control/{s_code}/{button_value}")
	public ModelAndView adminValue(@PathVariable("button_value") String button_value,
			@PathVariable("s_code") String s_code, HttpServletResponse response, HttpServletRequest request)
			throws Exception {

		ModelAndView modelAndView = new ModelAndView();
		Map<String, Object> map = new HashMap<>();

		switch (button_value) {
		
		case "standard_code":

			StandardCode sCodeVO = standardservice.getStandardCodeBySCode(Long.parseLong(s_code));

			if (sCodeVO == null) {
				System.out.println(">> getSCodeBySCode > sCodeVO is Empty");
				modelAndView.setViewName("redirect:/");
			} else {
				System.out.println(">> getSCodeBySCode > sCodeVO.drug_name = " + sCodeVO.getDrug_name_kr());
				map.put("function", "getScodeBySCode");
				map.put("sCode", sCodeVO);
				modelAndView.addObject("data", map);
				modelAndView.addObject("button_value", button_value);
				modelAndView.setViewName("page/adminControl");
			}

			break;

		case "insurance_covered":

			InsuranceCovered icCodeVO = standardservice.getStandardCodeByICCode(s_code);

			if (icCodeVO == null) {
				System.out.println(">> getICCodeByICCode > icCodeVO is Empty");
				modelAndView.setViewName("redirect:/");
			} else {
				System.out.println(">> getICCodeByICCode > icCodeVO.drug_name = " + icCodeVO.getDrug_name_kr());
				map.put("function", "getICcodeByICCode");
				map.put("icCode", icCodeVO);
				modelAndView.addObject("data", map);
				modelAndView.addObject("button_value", button_value);
				modelAndView.setViewName("page/adminControl");
			}

			break;

		case "main_ingredient":
			
			MainIngredient mcCodeVO = standardservice.getStandardCodeByMICode(s_code);

			if (mcCodeVO == null) {
				System.out.println(">> getMCCodeByMCCode > mcCodeVO is Empty");
				modelAndView.setViewName("redirect:/");
			} else {
				System.out.println(">> getMCCodeByMCCode > mcCodeVO.drug_name = " + mcCodeVO.getMain_ingredient_code());
				map.put("function", "getScodeBySCode");
				map.put("mcCode", mcCodeVO);
				modelAndView.addObject("data", map);
				modelAndView.addObject("button_value", button_value);
				modelAndView.setViewName("page/adminControl");
			}

			break;
		}

		return modelAndView;

	}

	@RequestMapping("/deletevalue/{s_code}/{button_value}")
	public ModelAndView delete(@PathVariable("button_value") String button_value, @PathVariable("s_code") String s_code, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();

		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();

		standardservice.delStandardCodeBySCode(Long.parseLong(s_code),button_value);

		out.println("<script>alert('삭제 되었습니다.')</script>");
		modelAndView.setViewName("page/adminpage");
		out.flush();

		return modelAndView;
	}

}
