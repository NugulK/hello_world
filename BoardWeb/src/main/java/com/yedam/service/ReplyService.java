package com.yedam.service;

import java.util.List;

import com.yedam.vo.ReplyVO;

// 업무프로세스(service)
public interface ReplyService {
	// 용어자체도 다르게 사용.
	List<ReplyVO> replyList(int boardNo); //목록조회.
	boolean addReply(ReplyVO rvo); //등록.
	boolean removeReply(int replyNo); //삭제.
	ReplyVO getReply(int replyNo); //단건조회.
}
