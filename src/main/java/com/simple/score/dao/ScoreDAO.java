package com.simple.score.dao;

import java.util.ArrayList;

import com.simple.command.ScoreVO;

public interface ScoreDAO {

	public void regist(ScoreVO vo); //서비스 영역에서 만든것과 거의 완전 동일하게 만듦
	public ArrayList<ScoreVO> getList();
	public void delete(int num);
}
