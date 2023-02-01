package com.simple.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/response")
public class ResponseController {

	//1. 화면
	@RequestMapping("/ex01") //입력경로
	public String ex01() {
		return "response/ex01"; //출력경로
	}
	
	//result01 요청 - model 객체
	@RequestMapping("/result01")
	public String result01(Model model) {
		
		model.addAttribute("data", "리자몽"); //키, 값
		model.addAttribute("serverTime", new Date());
		
		return "response/result01";
	}
	
	//request02 요청 - modelAdnView 객체
	@RequestMapping("/result02")
	public ModelAndView result02() {
		
		//뷰의 정보, data 정보를 함께 저장할 수 있는 객체
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", "그레이몬");
		mv.addObject("name", "디지몬");
		
		mv.setViewName("response/result02");		
		
		return mv;
	}
	
	
}
