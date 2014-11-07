package com.multicampus.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.multicampus.biz.board.BoardVO;

// DAO(Data Access Object)
@Repository
public class BoardDAOHibernate {
	@Autowired
	private HibernateTemplate hibernate;
	// 글 등록
	
	public void insertBoard(BoardVO vo){
		hibernate.save(vo);
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo){
		hibernate.update(vo);
	}	
	
	// 글 삭제
	public void deleteBoard(BoardVO vo){
		hibernate.delete(vo);
	}
	
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo){
		return hibernate.get(BoardVO.class, vo.getSeq());
	}
	
	// 글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo){
		return hibernate.find("from BoardVO b order by b.seq desc");
	}	
}














