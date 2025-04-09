package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.vo.EventVO;

public interface EventMapper {
	 // 1. 이벤트 추가
    int insertEvent(EventVO event);

    // 2. 이벤트 리스트 조회
    List<EventVO> selectEventList();
    
    // 3. 이벤트 삭제
    int deleteEvent(EventVO event);   
}
