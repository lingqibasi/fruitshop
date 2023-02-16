package com.qs.fruitshop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;

@Controller
public class DisplayImage {
	@RequestMapping(value = "/DisplayImage", method = RequestMethod.GET)
	public void display(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String src = request.getParameter("src");
		String file = "D:\\java\\images\\" + src;//本地
//		String file = "/myImage/" + request.getParameter("src");	//服务器
		response.setContentType("image/jpeg");
		ServletOutputStream out;
		out = response.getOutputStream();

		FileInputStream fin = new FileInputStream(file);

		BufferedInputStream bin = new BufferedInputStream(fin);
		BufferedOutputStream bout = new BufferedOutputStream(out);
		int ch = 0;
		while ((ch = bin.read()) != -1) {
			bout.write(ch);
		}
		bin.close();
		fin.close();
		bout.close();
		out.close();
	}
}