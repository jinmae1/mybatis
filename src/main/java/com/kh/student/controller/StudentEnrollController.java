package com.kh.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.AbstractController;

public class StudentEnrollController extends AbstractController {

	/**
	 * GET 학생등록폼 요청
	 */
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "student/studentEnroll"; // forwarding
	}
	
	/**
	 * POST 학생 DB등록 요청
	 */
	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return "redirect:/";
	}

	
}
