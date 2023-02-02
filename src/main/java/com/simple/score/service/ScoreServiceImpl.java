package com.simple.score.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.command.ScoreVO;
import com.simple.score.dao.ScoreDAO;

//@Component //@Repository //@Service //@Controller
//4개 다 같은 의미인데 여기는 service니까 service 써줘라

@Service("이름") //빈의 이름 명시
public class ScoreServiceImpl implements ScoreService {

	@Autowired //의존성 주입
	private ScoreDAO scoreDAO; //정확한 타입 들어감, ScoreDAO는 com.simple.score.dao.ScoreDAO임
	
	@Override
	public void regist(ScoreVO vo) {
		//System.out.println(vo.toString());
		
		scoreDAO.regist(vo);
	}

	@Override
	public ArrayList<ScoreVO> getList() {
		
		ArrayList<ScoreVO> list = scoreDAO.getList();
		//service에서 별다른 작업을 할게 없다면 return에 getList();를 바로 넣음
		
		return list;
	}

	@Override
	public void delete(int num) {
		scoreDAO.delete(num);
	}
	
	

}
