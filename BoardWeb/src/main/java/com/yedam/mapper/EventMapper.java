package com.yedam.mapper;

import java.util.List;
import java.util.Map;

public interface EventMapper {
	List<Map<String, Object>> selectEvent();
    int insertEvent(Map<String, Object> data);
    int deleteEvent(Map<String, Object> data);
	
	// 차트.
	List<Map<String, Object>> selectWriter();
	// 로그.
	int insertLogging(Map<String, String> map);
 }
