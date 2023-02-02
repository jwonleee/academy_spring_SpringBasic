package com.simple.score.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.simple.command.ScoreVO;

@Repository //DAO영역에서는 이거 사용 ▷ 오버라이딩하고 컴포넌트 스캔 부분 확인
public class ScoreDAOImpl implements ScoreDAO{

	//데이터베이스 - 가짜db
	ArrayList<ScoreVO> list = new ArrayList<>();
	
	@Override
	public void regist(ScoreVO vo) {
		//System.out.println("DAO영역: " + vo.toString());
		list.add(vo); //insert임
	}

	@Override
	public ArrayList<ScoreVO> getList() {
		//데이터조회
		return list;
	}

	@Override
	public void delete(int num) {
		//삭제작업
		list.remove(num);
	}
	
}
