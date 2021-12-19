package com.kh.student.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.common.AbstractController;
import com.kh.student.model.service.IStudentService;
import com.kh.student.model.vo.Student;

public class StudentUpdateController extends AbstractController {
	
	private IStudentService studentService;

	public StudentUpdateController(IStudentService studentService) {
		this.studentService = studentService;
		System.out.println("[StudentUpdateController] studentService = " + studentService);
	}

	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "student/studentUpdate"; // forwarding
	}

	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 사용자 입력값 처리
		int no = Integer.parseInt(request.getParameter("no"));
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		Student student = new Student(no, name, tel, null);
		System.out.println("[StudentUpdateController] student = " + student);
		
		// 2. 업무로직 요청
		int result = studentService.updateStudent(student);
		
		// 3. 사용자 피드백 (redirect)
		response.setContentType("application/json; charset=utf-8");
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("msg", "정보 수정 성공!");
		new Gson().toJson(resultMap, response.getWriter());

		return null;
	}

}
