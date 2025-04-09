package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.EventMapper;
import com.yedam.vo.EventVO;

public class EtcServiceImpl implements EtcService{
	SqlSession session = DataSource.getInstance().openSession(true);
    EventMapper mapper = session.getMapper(EventMapper.class);

    @Override
    public boolean addEvent(EventVO event) {
        try {
            mapper.insertEvent(event);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false; // 예외 처리
        }
    }

    @Override
    public List<EventVO> selectEventList() {
    	return mapper.selectEventList();
    }

    @Override
    public boolean removeEvent(EventVO event) {
        try {
            mapper.deleteEvent(event);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false; // 예외 처리
        }
    }
}
