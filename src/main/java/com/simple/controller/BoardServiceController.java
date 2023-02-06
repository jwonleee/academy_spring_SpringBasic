package com.simple.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.board.service.BoardService;
import com.simple.command.BoardVO;

@Controller
@RequestMapping("/service")
public class BoardServiceController {

	//(화면 URL요청: 컨패스/service/boardRegister)
	
	@Autowired
	@Qualifier("boardService") //이름 지정 - serviceImpl하고 연결 - 아래와 같음
	private BoardService boardService; //인터페이스 타입 선언 - 이름 지을 때 ctrl+space 누르면 추천이름 나옴 

	//화면출력
	@RequestMapping("/boardRegister")
	public String registView() {
		return "service/boardRegister"; //view의 화면
	}
	
	//폼요청 - 등록화면
	@RequestMapping(value="/boardRegist", method=RequestMethod.POST)
	public String boardRegist(BoardVO vo) {
//		System.out.println(vo.toString());들어옴 확인
		boardService.boardRegist(vo);
		return "service/boardResult";
	}
	
	//목록화면
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		
		//data 조회
		ArrayList<BoardVO> list = boardService.getList();
//		System.out.println("list", list);
		model.addAttribute("list", list);
		return "service/boardList";
	}
	
	//삭제요청
	@RequestMapping("/boardDelete")
	public String delete(@RequestParam("num") int num) { //RequestParam은 boardList에 있는 키값인 num임
		boardService.boardDelete(num);
		return "redirect:/service/boardList";
	}
	
	
	
}
