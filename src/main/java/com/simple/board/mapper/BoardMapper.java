package com.simple.board.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.simple.command.BoardVO;

// BoardDAO를 myBatis로 해주려고 따로 안 만들려고
@Mapper //mybatis-scan 하게 하려고 root-context.xml 변경
public interface BoardMapper {

	public void boardRegist(BoardVO vo); //등록
	public ArrayList<BoardVO> getList(); //조회
	public void boardDelete(int num); //삭제

}
