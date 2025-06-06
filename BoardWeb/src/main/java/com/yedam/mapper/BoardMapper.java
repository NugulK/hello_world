package com.yedam.mapper;

import java.util.List;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

/*
 * 인터페이스(메소드정의) - 구현클래스 (메소드구현)
 */
public interface BoardMapper {
	//목록.
	List<BoardVO> selectBoard(SearchDTO search);
	//등록.
	int insertBoard(BoardVO board);
	//수정.
	int updateBoard(BoardVO board);
	//삭제.
	int deleteBoard(int boardNo);
	//상세조회
	BoardVO selectOne(int board);
	//전체건수.
	int selectTotal(SearchDTO search);
}
