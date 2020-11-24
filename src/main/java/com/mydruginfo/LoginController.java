package com.mydruginfo;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mydruginfo.model.AdminVO;
import com.mydruginfo.service.AdminService;

@Controller
public class LoginController {

	
	@Autowired
	AdminService loginService;

	@RequestMapping("/login")
	public String login() {
		return "page/login";
	}

	@RequestMapping("/loginCheck")
	@ResponseBody
	public ModelAndView loginCheck(@ModelAttribute AdminVO vo, HttpSession session, HttpServletResponse response)
			throws Exception {

		boolean result = loginService.checkAdmin(vo.getAdmin_id(), vo.getAdmin_pw());

		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();

		ModelAndView mav = new ModelAndView();

		if (result == true) {
			session.setAttribute("admin_id", vo.getAdmin_id());
			mav.setViewName("page/home");
			mav.addObject("msg", "success");
			out.println("<script>alert('로그인이 되었습니다.')</script>");
			out.flush();
		}

		else {
			mav.setViewName("page/login");
			mav.addObject("msg", "failure");
			out.println("<script>alert('아이디와 비밀번호를 확인해주세요.')</script>");
			out.flush();
		}

		return mav;

	}

	@RequestMapping("/logout")
	public void logout(HttpSession session, HttpServletResponse response) throws Exception {

		loginService.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("page/home");
		mav.addObject("msg", "logout");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('로그아웃 되었습니다.');location.href='/';</script>");
		
		out.flush();
	}

}
