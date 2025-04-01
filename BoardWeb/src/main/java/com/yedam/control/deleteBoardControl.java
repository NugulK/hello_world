package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;

public class deleteBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
				
		//수정처리.
		 SqlSession sqlSession = DataSource.getInstance().openSession(true);
         BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
         int r = mapper.deleteBoard(Integer.parseInt(bno));
		
		//목록이동.
		if(r > 0){
			resp.sendRedirect("boardList.do"); //요청재지정.
		}else {
			System.out.println("삭제오류.");				
		}
	}

}
