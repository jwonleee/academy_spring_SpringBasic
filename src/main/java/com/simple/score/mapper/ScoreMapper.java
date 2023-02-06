package com.simple.score.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.simple.command.ScoreVO;

// ScoreDAO를 myBatis로 바꾸려고
@Mapper //mybatis-scan 하게 하려고 root-context.xml 변경
public interface ScoreMapper {
	public void regist(ScoreVO vo); //서비스 영역에서 만든것과 거의 완전 동일하게 만듦
	public ArrayList<ScoreVO> getList();
	public void delete(int num);
}
