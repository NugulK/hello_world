package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class removeReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//  파라메타값은 rno = 2
		String rno = req.getParameter("rno");
		
		ReplyService svc = new ReplyServiceImpl();
		if(svc.removeReply(Integer.parseInt(rno))) {
			// {"retCode": "OK"}
			resp.getWriter().print("{\"retCode\": \"OK\"}");
		}else {
			// {"retCode": "NG"}
			resp.getWriter().print("{\"retCode\": \"NG\"}");
		}
	}
}
