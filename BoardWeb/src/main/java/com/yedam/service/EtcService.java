package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.vo.EventVO;

public interface EtcService {
	// 이벤트 등록
    public boolean addEvent(EventVO event);

    // 이벤트 목록 조회
    public List<EventVO> selectEventList();

    // 이벤트 삭제
    public boolean removeEvent(EventVO event);
}
