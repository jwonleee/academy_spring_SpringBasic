package com.simple.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.ReqVO;

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
	
	//@ModelAttribute = req + model
	@RequestMapping("/result03") //aaa로 담아주면서 타입을 정해줌
	public String result03(@ModelAttribute("num") String aaa) {
		
		System.out.println("화면데이터: " + aaa);
		
		return "response/result03";
	}
	
	@RequestMapping("/result04")
	public String result04(@ModelAttribute("article") ReqVO vo) {//뒤에 온 값(ReqVO vo)을 article이라는 이름으로 던져주겠다 
		
		System.out.println("화면데이터:" + vo.toString());
		
		return "response/result04";
	}
	
	//////////////////////////////////////////////////////////////////
	//redirect 이동과 redirectAttribute
	//스프링에서 redirect는 다시 컨트롤러를 태우는 요청입니다.
	//redirectAttribute는 redirect시에 1회성 데이터를 저장할 수 있습니다.
	
	//화면요청
	@RequestMapping("/redirect_login")
	public String loginView() {
		
		return "response/redirect_login";
	}
	
	//로그인 요청
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("id") String id,
						@RequestParam("pw") String pw,
						RedirectAttributes ra) { //파라미터로 객체(?) 선언하면 바로 사용 가능
		
		//로그인 성공 ▷ home 화면으로
		if(id.equals(pw)) {
			
			ra.addFlashAttribute("msg","어서와"); //일회성 데이터
			
			//데이터를 실어서 가져갈 것은 아님
			//그래서 homeController를 다시 태워서 home화면으로 나가게 해 줄 것임
			return "redirect:/"; //다시 home 컨트롤러를 태워 보냄 -model을 사용할 수는 없음
			
		//로그인 실패
		} else {
			ra.addFlashAttribute("msg","틀렸는데요?ㅋ");
			return "redirect:/response/redirect_login"; //"redirect:/절대경로"
		}
			
//		return null;
	}
	
	
}
