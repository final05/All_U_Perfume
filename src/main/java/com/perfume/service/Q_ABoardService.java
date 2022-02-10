package com.perfume.service;

import java.util.List;

import com.perfume.beans.BoardDTO;
import com.perfume.beans.Paging;
import com.perfume.beans.RE_BoardDTO;
import com.perfume.beans.SearchCriteria;

public interface Q_ABoardService {
	public int q_ainsert(BoardDTO board); // 게시글 작성
	public BoardDTO q_aContent(BoardDTO board); // readcount
	public int q_adelete(String b_number); // 게시글 삭제
	public int q_aupdate(BoardDTO board); // 게시글 업데이트
	public int q_areadcount(int b_number); // 조회수 증가
	// 게시글 총 갯수
	public int countQ_aBoard(SearchCriteria scri);
	
	// 페이징 처리 게시글 목록
	public List<BoardDTO> selectQ_aBoard(SearchCriteria scri);
	
	// 답글 작성하기
	public int q_a_re_insert(RE_BoardDTO reboard);
	

}
