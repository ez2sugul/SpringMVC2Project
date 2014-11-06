package com.multicampus.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.multicampus.biz.board.BoardVO;
import com.multicampus.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		// 1. 사용자 입력정보 추출
		String searchCondition = request.getParameter("searchCondition");
		String searchKeyword = request.getParameter("searchKeyword");
		
		// Null Check
		if(searchCondition == null) searchCondition = "TITLE";
		if(searchKeyword == null) searchKeyword = "";
		
		// 2. DB 연동
		BoardVO vo = new BoardVO();
		vo.setSearchCondition(searchCondition);
		vo.setSearchKeyword(searchKeyword);

		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo); 
		
		// 3. 응답 화면 구성
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList); // Model 정보 저장
		mav.setViewName("getBoardList");       // View  정보 저장
		// ModelAndView에 저장된 데이터는 request에 자동으로 등록된다.
		return mav;
	}

}










