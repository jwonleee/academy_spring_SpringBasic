package com.simple.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ScoreVO;
import com.simple.score.service.ScoreService;
import com.simple.score.service.ScoreServiceImpl;

@Controller
@RequestMapping("/service")
public class ServiceController {

	//1st
	//ScoreServiceImpl service = new ScoreServiceImpl();
	
	//2nd - service를 bean으로 생성한다. 의존객체 자동주입
	
	//3rd - @Service로 빈을 생성하고, 의존객체 자동주입
	@Autowired
	@Qualifier("이름") //이름을 통한 강제 연결 가능, 보통 멤버변수명을 따라감 여기서는 service
	private ScoreService service; //인터페이스 타입 선언
	
	//화면출력
	@RequestMapping("/scoreRegist")
	public String registView() {
		return "service/scoreRegist";
	}
	
	//폼요청
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String regist(ScoreVO vo) {
	//System.out.println(vo.toString()); //데이터가 잘 들어왔는지 확인
		
		service.regist(vo);
		return "service/scoreResult";
	}
	
	//목록화면
	@RequestMapping("/scoreList")
	public String scoreList(Model model) {
		
		//data조회
		ArrayList<ScoreVO> list = service.getList();
		//System.out.println(list.toString());
		model.addAttribute("list", list);
		
		return "service/scoreList";
	}
	
	//삭제요청
	@RequestMapping("/delete")
	public String delete(@RequestParam("num") int num) { //단일값이면서 반드시 넘겨줘야하는 값은 RequestParam이 좋음
		
		System.out.println(num);
		service.delete(num);

		return "redirect:/service/scoreList";
		//리스트를 다 지웠기 때문에 리스트를 다시 긁어와서 쫘악 뿌려줘야함
	}
	
	
	

	
}
