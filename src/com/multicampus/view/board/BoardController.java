package com.multicampus.view.board;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.multicampus.biz.board.BoardService;
import com.multicampus.biz.board.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	// 글 등록
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {
		// 파일 업로드 구현 
		MultipartFile uploadFile = vo.getUploadFile();
		if (uploadFile.getOriginalFilename().length() > 0) {
			String fileName = uploadFile.getOriginalFilename();
			byte[] data = uploadFile.getBytes();
			FileOutputStream out = new FileOutputStream("C:/DEV/workspace/SpringMVC2Project/WebContent/uploadFiles/" + fileName);
			out.write(data);
			out.close();
		}
		boardService.insertBoard(vo);		
		return "getBoardList.do";
	}
	
	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo) {
		boardService.updateBoard(vo);		
		return "getBoardList.do";
	}
	
	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);		
		return "getBoardList.do";
	}
	
	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo)); // Model 정보 저장
		return "getBoard.jsp";       // View  정보 저장
	}
	
	// 글 목록 조회
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		model.addAttribute("boardList", boardService.getBoardList(vo)); // Model 정보 저장
		return "getBoardList.jsp";       // View  정보 저장
	}
}
