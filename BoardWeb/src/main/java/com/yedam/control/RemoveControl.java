package com.yedam.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.EtcService;
import com.yedam.service.EtcServiceImpl;
import com.yedam.vo.EventVO;

public class RemoveControl implements Control {

	@Override
	 public void exec(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8"); // 🔥 POST 한글 처리

            String title = req.getParameter("title");
            String start = req.getParameter("start");

            EventVO vo = new EventVO();
            vo.setTitle(title);
            vo.setStartDate(start);

            EtcService service = new EtcServiceImpl();
            boolean result = service.removeEvent(vo);

            resp.setContentType("text/plain;charset=utf-8"); // 🔥 응답 설정
            resp.getWriter().print(result ? "success" : "fail");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
