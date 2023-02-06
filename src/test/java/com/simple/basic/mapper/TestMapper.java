package com.simple.basic.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.simple.command.ScoreVO;

@Mapper //마이바티스 매퍼를 지정 - (스프링에서는 생략 가능)
public interface TestMapper {
	
	public String getTime(); //1
	public ArrayList<ScoreVO> getScore() ;
	public ScoreVO getOne(int a);
	
	public int insertOne(String name); //단일값
	public int insertTwo(ScoreVO vo); //다중값
	public int insertThree(Map<String, String> map); //다중값

	public Map<String, Object> selectMap(int num); //6번 키값 조회
	public ArrayList<Map<String, Object>> selectTwo(); //맵을 통한 다중행 맵타입, 다중행 맵타입 - 제네릭 안에 map이 들어감
	//[{}, {}, {}]
	
	public boolean updateOne(ScoreVO vo); //update (6번 업데이트)
	
	
	public void insertFour(@Param("변수명1") String name, @Param("변수명2") int kor); //매개변수가 2개 이상
	
}
