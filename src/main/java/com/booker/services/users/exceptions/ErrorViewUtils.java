package com.booker.services.users.exceptions;

import org.springframework.web.servlet.ModelAndView;

public class ErrorViewUtils {
	public static void createErrorView(ModelAndView view, String message) {
		view.setViewName("errorView");
		view.addObject("error", message);
	}
}
