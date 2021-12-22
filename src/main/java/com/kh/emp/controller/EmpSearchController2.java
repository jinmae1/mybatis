package com.kh.emp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.AbstractController;
import com.kh.emp.model.service.EmpService;

/**
 * interface - 구현클래스
 * 1. IService - StudentService
 * 2. StudentService - StudentServceImpl
 * 앞으로 2번 방식으로 명명함
 */
public class EmpSearchController2 extends AbstractController {

	private EmpService empService;

	public EmpSearchController2(EmpService empService) {
		this.empService = empService;
	}

	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자 입력값
		Map<String, Object> param = new HashMap<>();
		param.put("searchType", request.getParameter("searchType")); // 다른 데서 왔다면 null이고, 폼이 제출되었다면 빈 문자열일 수 있다.
		param.put("searchKeyword", request.getParameter("searchKeyword")); // 다른 데서 왔다면 null이고, 폼이 제출되었다면 빈 문자열일 수 있다.
		param.put("gender", request.getParameter("gender")); // 여기서 두번째 인자는 null일 수 있다.
		param.put("salary", request.getParameter("salary")); // null이거나 ''일 수 있다. input type에 따라서 값이 없어도 빈문자열이 전달되기 때문
		param.put("salaryCompare", request.getParameter("salaryCompare")); // null이거나 ''일 수 있다. input type에 따라서 값이 없어도 빈문자열이 전달되기 때문
		param.put("hireDate", request.getParameter("hireDate"));
		param.put("hiredateCompare", request.getParameter("hiredateCompare"));
		System.out.println("[EmpSearchController2] param = " + param);

		// 2. 업무로직
		List<Map<String, Object>> list = empService.search2(param);
		System.out.println("[EmpSearchController2] list = "  + list);
		
		// 3. jsp 위임
		request.setAttribute("list", list);

		return "emp/search2";
	}
	
	

}
