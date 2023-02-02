package com.simple.score.service;

import java.util.ArrayList;

import com.simple.command.ScoreVO;

public interface ScoreService {
	//service구현체에서 사용할 추상메서드의 모형을 선언
	
	public void regist(ScoreVO vo);
	public ArrayList<ScoreVO> getList();
	public void delete(int num); //딱히 가져올게 없으니까 void, 매개변수는 있으니까 int num
}
