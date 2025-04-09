package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.common.SearchDTO;
import com.yedam.vo.ReplyVO;

// 업무프로세스(service)
public interface ReplyService {
	// 용어자체도 다르게 사용.
	List<ReplyVO> replyList(SearchDTO search); //목록조회.
	boolean addReply(ReplyVO rvo); //등록.
	boolean removeReply(int replyNo); //삭제.
	ReplyVO getReply(int replyNo); //단건조회.
	// 페이징 계산.
	int getTotalCnt(int boardNo);
	// Datatable용 데이터.
	List<Map<String, Object>> replyListForDT(int boardNo);
}
