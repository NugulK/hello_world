package com.yedam.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.EtcService;
import com.yedam.service.EtcServiceImpl;
import com.yedam.vo.EventVO;

public class AddEventControl implements Control {

	@Override
	 public void exec(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8"); // 🔥 추가: 한글 POST 처리

			String title = req.getParameter("title");
			String start = req.getParameter("start");
			String end = req.getParameter("end");

			EventVO vo = new EventVO();
			vo.setTitle(title);
			vo.setStartDate(start);
			vo.setEndDate(end);

			EtcService service = new EtcServiceImpl();
			boolean result = service.addEvent(vo);

			resp.setContentType("text/plain;charset=utf-8");
			resp.getWriter().print(result ? "success" : "fail");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
