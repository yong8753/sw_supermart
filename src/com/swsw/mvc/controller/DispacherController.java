﻿package com.swsw.mvc.controller;

import javax.servlet.*;
import javax.servlet.http.*;

import com.swsw.mvc.action.CommandAction;

import java.io.*;
import java.util.*;//HashMap

// 문법은 java와 servlet 문법이다 
//컨트롤러=서블릿이다 
//스프링 에서는 front controller 라 한다 
public class DispacherController extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 4382893576874033285L;
	private Map<String, Object> map = new HashMap<>();// 변수

	// init() : 초기화 작업
	public void init(ServletConfig config) throws ServletException {

		String path = config.getServletContext().getRealPath("/");
		System.out.println("realpath:" + path);

		String pros = path + config.getInitParameter("proFile");
		Properties pr = new Properties();// 객체생성

		FileInputStream f = null;

		try {
			f = new FileInputStream(pros);// CommancPro.properties 읽기
			pr.load(f);/////
		} catch (Exception ex) {
			System.out.println("파일 읽기 예외 :" + ex);
		} finally {
			try {
				if (f != null) {
					f.close();
				}
			} catch (Exception ex2) {
			}
		} // finally---

		Iterator<Object> keyItor = pr.keySet().iterator();

		while (keyItor.hasNext()) {// 자료가 있는 동안 반복

			String key = (String) keyItor.next();// /ch19/list.do
			String className = pr.getProperty(key);// ch19.action.ListAction

			try {
				Class commandClass = Class.forName(className);// 해당문자열을 클래스로 만든다
				Object commandObject = commandClass.newInstance();// 클래스를 객체생성
				map.put(key, commandObject);///
				// key value
			} catch (Exception ex3) {
				System.out.println("proeprty 파일내용을 클래스 객체로 만드는 중 예외 발생 " + ex3);
			} // catch

		} // while end---
	}// init() end----------

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		reqPro(request, response);// 메서드 호출
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		reqPro(request, response);// 메서드 호출
	}

	// 사용자 정의 메서드
	private void reqPro(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String view = "";// jsp넣을 변수

		CommandAction commandAction = null;// Action클래스 넣을 변수

		// http://localhost /08_JSTL/01_jstl/01_set_remove.jsp
		// http://localhost /10_MVC/ch19/list.do
		//

		try {
			String uri = request.getRequestURI();// /프로젝트명/ch19/list.do
			// uri="/10_MVC/ch19/list.do";
			// request.getContextPath() => /10_MVC
			if (uri.indexOf(request.getContextPath()) == 0) {
				uri = uri.substring(request.getContextPath().length());
				// /ch19.list.do
			} // if

			commandAction = (CommandAction) map.get(uri);// key==> /ch19/list.do
			// //key 해당하는 Action 객체를 얻어낸다

			// view는 /ch19/list.jsp 이다
			view = commandAction.requestPro(request, response);// 메서드 호출 ,view 얻는다
			// 객체.메서드()
		} catch (Throwable ex) {
			throw new ServletException(ex);
		} // catch

		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);// jsp로 포워딩
	}// reqPro() end
}
