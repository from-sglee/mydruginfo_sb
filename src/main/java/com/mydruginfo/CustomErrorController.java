package com.mydruginfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrorController implements ErrorController {

	@RequestMapping(value = "/error")
	public ModelAndView handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		ModelAndView mv = new ModelAndView();
		if (status != null) {
			String message = "Unexpected Error";
			int statusCode = Integer.valueOf(status.toString());
			//System.out.println(">> error reason ; " +HttpStatus.valueOf(statusCode).toString());
			if (!HttpStatus.valueOf(statusCode).name().isEmpty()) {
				message = HttpStatus.valueOf(statusCode).name().replaceAll("_", " ");;
			}
			
			mv.setViewName("page/error");
			mv.addObject("errCode", status);
			mv.addObject("errMsg", message);
		}
		return mv;
	}

	@Override
	public String getErrorPath() {
		return "page/error";
	}
}
