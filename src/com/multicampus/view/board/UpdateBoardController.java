package com.multicampus.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.multicampus.biz.board.BoardVO;
import com.multicampus.biz.board.impl.BoardDAO;

public class UpdateBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		// 1. ����� �Է�����(seq, title, content) ����
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 2. DB ����
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		vo.setTitle(title);
		vo.setContent(content);
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.updateBoard(vo);
		
		// 3. ȭ�� �̵�(�� ��� ȭ������...)
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		return mav;
	}

}
