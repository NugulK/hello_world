package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.AddEventControl;
import com.yedam.control.AddReplycontrol;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.ChartControl;
import com.yedam.control.ChartJsonCont;
import com.yedam.control.LoginControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.ModifyFormControl;
import com.yedam.control.RLDatatable;
import com.yedam.control.RemoveControl;
import com.yedam.control.ReplyCountControl;
import com.yedam.control.ReplyListControl;
import com.yedam.control.SignUpControl;
import com.yedam.control.removeReplyControl;
import com.yedam.control.DeleteBoardControl;
import com.yedam.control.DeleteFormControl;
import com.yedam.control.EventFormControl;
import com.yedam.control.EventListControl;
import com.yedam.control.JSControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.MainControl;

// *.do의 요청에 실행.
public class FrontController extends HttpServlet {
	// 요청url <=> 실행컨트롤.
	Map<String, Control> map;
	// 생성자.
	public FrontController() {
		map = new HashMap<String, Control>();
	}
	
	// init 메소드
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainControl()); // 메인화면
		
		map.put("/board.do", new BoardControl()); // 상세화면.
		map.put("/boardList.do", new BoardListControl()); // 목록.
		map.put("/addBoard.do", new AddBoardControl()); // 글등록. AddBoardControl
		map.put("/modifyForm.do", new ModifyFormControl()); // 수정화면.
		map.put("/modifyBoard.do", new ModifyBoardControl()); //수정처리.
		map.put("/deleteForm.do", new DeleteFormControl()); //삭제화면
		map.put("/deleteBoard.do", new DeleteBoardControl()); //삭제처리.
		// 로그인관련.
		map.put("/loginForm.do", new LoginFormControl()); // 로그인화면
		map.put("/login.do", new LoginControl()); // 로그인 처리.
		map.put("/logout.do", new LogoutControl()); // 로그아웃.
		//회원가입.
		map.put("/signForm.do", new SignUpControl()); // 회원가입화면.
		map.put("/signUp.do", new SignUpControl()); // 회원등록.
		//자바스크립스 연습
		map.put("/javascript.do", new JSControl()); //자바스크립트연습.
		//댓글관련.
		map.put("/replyList.do", new ReplyListControl()); // 댓글데이터.
		map.put("/removeReply.do", new removeReplyControl()); //댓글삭제.
		map.put("/addReply.do", new AddReplycontrol()); // 댓글추가
		map.put("/replyCount.do", new ReplyCountControl()); // 댓글수.
		// Datatable 연습용.
		map.put("/replyListDatatable.do", new RLDatatable()); // 댓글목록.
		
		// fullcalendar관련.
		map.put("/eventForm.do", new EventFormControl()); //이벤트 화면 컨트롤.
		map.put("/addevent.do", new AddEventControl()); //추가이벤트 컨트롤.
		map.put("/removeEvent.do", new RemoveControl()); //추가이벤트 컨트롤.
		map.put("/eventList.do", new EventListControl()); //추가이벤트 컨트롤.
		// 구글차트.
		map.put("/chart.do", new ChartControl());
		map.put("/chartJson.do", new ChartJsonCont());
	}
	// service 메소드.
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// url vs. uri
		// url = http://localhost:8080/BoardWeb/board.do
		// uri = /BoardWeb/board.do
		System.out.println("service메소드 실행.");
		String uri =  req.getRequestURI();
		System.out.println("요청 URI: " + uri); // /BoardWeb/board.do
		String context = req.getContextPath();
		String page = uri.substring(context.length()); // "/board.do"
		System.out.println(page);
		
		Control sub = map.get(page); // 키 (url) = > control 반환.
		sub.exec(req, resp);
	}
}
