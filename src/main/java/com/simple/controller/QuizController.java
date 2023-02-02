package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.Quiz01VO;
import com.simple.command.Quiz03VO;

@Controller
@RequestMapping("/quiz")
public class QuizController {

	//화면요청 - quiz01
	@RequestMapping("/quiz01") //입력경로
	public String quiz01() {
		return "quiz/quiz01"; //출력경로
	}
//	혹은 (위와 같음)
//	public void quiz01() {}
	
	@RequestMapping("/sendBirth") //폼 요청
	public String quiz01(@ModelAttribute("birth") Quiz01VO vo) {
		String year = vo.getYear();
		String month = vo.getMonth();
		String day = vo.getDay();
		
		System.out.println(year+month+day);
		return "quiz/quiz01_ok"; //출력경로
	}
	
	/*
	 * @RequestMapping("/sendBirth") //입력경로, 폼요청
	 * quiz01(Quiz01VO vo, Model model ) { 여기 모델 넣어서 하는 법 다시해보기
	 * 
	 * 		model.addAttribute("birth", vo.getYear() + "년" +
	 * 							   vo.getMonth() + "월" +
	 * 							   vo.getDay() + "일");
	 * 
	 * 		System.out.println(year + month + day);
	 * 		return "quiz/quiz01_ok"; //출력경로
	 * }
	 */
	
	
	//화면요청 - quiz02
	@RequestMapping("/quiz02") //입력경로, 1. url 입력하면 컨트롤러에서 이걸 잡아챔
	public String quiz02() {
		return "quiz/quiz02"; //출력경로, 2. 이 파일을 뿌려줌
	}
	
	@RequestMapping("/join") //4. quiz02에서 join으로 보내는데 컨트롤러에 같은데 있어서 그것을 또 잡아챔
	public ModelAndView join(@RequestParam("id") String id,
							 @RequestParam("pw") String pw,
							 @RequestParam("name") String name,
							 @RequestParam("email") String email) {

		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);
		mv.addObject("pw", pw);
		mv.addObject("name", name);
		mv.addObject("email", email);
		
		mv.setViewName("quiz/quiz02_ok"); //5. 이거 보여줘
		return mv;
	}
	
	
	//화면요청 - quiz03
	@RequestMapping("/quiz03")
	public String quiz03() {
		return "quiz/quiz03";
	}
	
	//마지막 else 부분을 리다이렉트로 넘겨주고 싶으면 이거 적어주면 됨
	@RequestMapping("/quiz03_ok")
	   public String quiz03_ok() {
	      return "quiz/quiz03_ok";
	}
	
	@RequestMapping(value="/join2", method=RequestMethod.POST)
	public String join2(@ModelAttribute("info") Quiz03VO vo, RedirectAttributes ra) {
		
		String id = vo.getId();
		String pw = vo.getPw();
		String pw_check = vo.getPw_check();
		
		System.out.println(id + pw + pw_check); //들어오는 것까지 확인
		
		if(id.equals("")) {
			ra.addFlashAttribute("msg", "아이디를 다시 입력하세요");
			return "redirect:/quiz/quiz03";
			
		} else if(!pw.equals(pw_check) || pw.equals("")){
			ra.addFlashAttribute("msg", "비밀번호를 확인하세요");
			return "redirect:/quiz/quiz03";
			
		} else { //여기에도 리다이렉트 걸어주면 위의 화면요청-quiz03으로 가버림
			return "quiz/quiz03_ok";
		}
	}
	
	//리다이렉트로 보내는 다른 방법 - 모델로 나가는게 맞음
//	@RequestMapping("/quiz03_ok")
//	   public String quiz03_ok() {
//	      return "quiz/quiz03_ok";
//	   }
//	   
//	   @RequestMapping(value = "/join2", method = RequestMethod.POST)
//	   public String join2(@RequestParam("id") String id,
//	                  @RequestParam("pw") String pw,
//	                  @RequestParam("pw_check") String pw_check,
//	                  RedirectAttributes ra,
//	                  Model model) {
//	      
//	      if(id.equals("")) {
//	         ra.addFlashAttribute("msg", "아이디를 확인하세요");
//	         return "redirect:/quiz/quiz03";
//	      } else if(!pw.equals(pw_check) || pw.equals("")) {
//	         ra.addFlashAttribute("msg", "비밀번호를 확인하세요");
//	         return "redirect:/quiz/quiz03";         
//	      } else {
//	         ra.addFlashAttribute("id", id);
////	         model.addAttribute("id", id);
//	         return "redirect:/quiz/quiz03_ok";
//	      }
//	   }
	
	
}
