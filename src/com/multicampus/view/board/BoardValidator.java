package com.multicampus.view.board;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.multicampus.biz.board.BoardVO;

public class BoardValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		BoardVO board = (BoardVO) target;
		
//		if(board.getTitle().length() == 0 || board.getTitle() == null) {
//			errors.rejectValue("title", "error.board.title");
//		}
//		
//		if(board.getWriter().length() == 0 || board.getWriter() == null) {
//			errors.rejectValue("writer", "error.board.writer");
//		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.board.title");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "writer", "error.board.writer");
		
		if(board.getContent().length() < 10) {
			errors.rejectValue("content", "error.board.content");
		}

	}

}













