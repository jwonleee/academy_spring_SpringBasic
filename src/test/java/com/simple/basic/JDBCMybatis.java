package com.simple.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simple.basic.mapper.TestMapper;
import com.simple.command.ScoreVO;

@RunWith(SpringJUnit4ClassRunner.class) //junit으로 테스트환경을 구성
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml") //동작시킬 스프링 설정 파일 - 전체 풀 경로
public class JDBCMybatis {
	
//	@Autowired
//	SqlSessionFactoryBean sqlSessionFactory;
//	
//	@Test
//	public void testCode01() {
//		//마이바티스 핵심 객체
//		System.out.println(sqlSessionFactory);
//	}
	
	@Autowired
	TestMapper testMapper;
	
//	@Test
//	public void testCode02() {
//		String time = testMapper.getTime();
//		System.out.println(time);
//	}
	
	//select 태그의 resultType
//	@Test
//	public void testCode03() {
//		ArrayList<ScoreVO> list = testMapper.getScore();
//		System.out.println(list.toString());
//	}
	
	//매개변수 - 단일값
//	@Test
//	public void testCode04() {
//		ScoreVO vo = testMapper.getOne(7);
//		System.out.println(vo.toString());
//	}
	
	//insert - 단일값
//	@Test
//	public void testCode05() {
//		int result = testMapper.insertOne("이순신");
//		System.out.println("성공실패:" + result);
//	}
	
	//insert - 다중값 (vo) - setter가 파라미터가 됩니다.
//	@Test
//	public void testCode06() {
//		ScoreVO vo = new ScoreVO(0, "테스트", "60", "50");
//		int result = testMapper.insertTwo(vo);
//		System.out.println("성공실패:" + result);
//	}
	
	//insert - 다중값 (Map) : 키값이 중요, key값이 파라미터가 됩니다.
//	@Test
//	public void testCode07() {
//		Map<String, String> map = new HashMap<>();
//		map.put("name", "앨리스"); 
//		map.put("kor", "100");
//		map.put("eng", "10");
//		
//		int result = testMapper.insertThree(map);
//		System.out.println("성공실패:" + result);
//	}
	
	//select - map타입의 반환
//	@Test
//	public void testCode08() {
//		Map<String, Object> map = testMapper.selectMap(6);
//		System.out.println(map.toString());
//	}
	
	//select - map타입의 반환: 맵 타입을 사용하는 것은 부득이한 경우에만 사용합니다.
//	@Test
//	public void testCode09() {
//		ArrayList<Map<String, Object>> list = testMapper.selectTwo();
//		System.out.println(list.toString());
//	}
	
	//update
//	@Test
//	public void testCode10() {
//		ScoreVO vo = new ScoreVO(6, "변경", "100", "100");
//		boolean result = testMapper.updateOne(vo);
//		System.out.println("성공실패:" + result);
//	}
	
	//insert구문 @Param - 매개변수
	@Test
	public void testCode11() {
		testMapper.insertFour("파람테스트", 100);
	}
	
}
