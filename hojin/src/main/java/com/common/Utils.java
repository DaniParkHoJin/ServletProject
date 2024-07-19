package com.common;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


public class Utils {

	public static void parameterCheck(HttpServletRequest request) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		Enumeration<String> enu = request.getParameterNames();
		
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String[] values = request.getParameterValues(name);
			for (String value : values) {
				System.out.println("파라미터명: " + name + ", 파라미터값: " + value);
			}
			
		}
	}
	
	
}
