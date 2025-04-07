package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.ReplyVO;

// 댓글목록, 등록, 삭제, 단건조회.
public interface ReplyMapper {
	//메소드 정의.
	List<ReplyVO> selectList(int boarNo); // 댓글목록.
	int insertReply(ReplyVO rvo); // 댓글등록.
	int deleteReply(int replyNo); // 댓글삭제.
	ReplyVO selectReply(int replyNo); // 단건조회.
	
	// 쿼리생성.
	// ReplyMapper.xml에
}
