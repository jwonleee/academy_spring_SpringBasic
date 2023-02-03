package com.simple.score.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.simple.command.ScoreVO;

@Repository("yyy") //DAO영역에서는 이거 사용 ▷ 오버라이딩하고 컴포넌트 스캔 부분 확인
public class ScoreDAOImpl implements ScoreDAO{

	@Autowired
	DataSource dataSource;
	
	//insert
	@Override
	public void regist(ScoreVO vo) {
	
		String sql = "insert into score(name, kor, eng) values(?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getKor());
			pstmt.setString(3, vo.getEng());
			
			pstmt.executeUpdate(); //insert, update, delete
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
			}
		}
		
	}
	
	//
	@Override
	public ArrayList<ScoreVO> getList() {
		
		ArrayList<ScoreVO> list = new ArrayList<>();
		
		String sql = "select * from score order by num desc";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//ORM
			while(rs.next()) {
				
				ScoreVO vo = new ScoreVO(); //vo 배열을 만들고
				vo.setNum( rs.getInt("num") ); //vo.setNum으로 담아줌
				vo.setName( rs.getString("name"));
				vo.setKor( rs.getString("kor"));
				vo.setEng( rs.getString("eng"));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
			}
		}
		
		return list;
	}

	//delete
	@Override
	public void delete(int num) {
		
		//삭제기능 -
		//num은 key가 아니라 index가 넘어옵니다. (화면에 key를 넘기도록 변경)
		//delete 기능 구현
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from score where num=?"; //sql문으로 지움
		
		try {
			conn = dataSource.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
			}
		}

	}
	
	
//
//	//데이터베이스 - 가짜db
//	ArrayList<ScoreVO> list = new ArrayList<>();
//	
//	@Override
//	public void regist(ScoreVO vo) {
//		
//		//연결
//		//connect
////		Class.forName("드라이버클래스")
//		
//		//System.out.println("DAO영역: " + vo.toString());
//		list.add(vo); //insert임
//	}
//
//	@Override
//	public ArrayList<ScoreVO> getList() {
//		//데이터조회
//		return list;
//	}
//
//	@Override
//	public void delete(int num) {
//		//삭제작업
//		list.remove(num);
//	}
//	
}
