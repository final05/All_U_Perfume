package com.perfume.service;

import java.util.List;

import com.perfume.beans.BoardDTO;

public interface NoticeBoardService {
	public List<BoardDTO> getList(); // 게시판 글 목록 리턴할 메서드
	public int noticeinsert(BoardDTO board); // 게시글 작성
	public BoardDTO noticeReadCount(int b_number); // readcount
	public int noticedelete(int b_number); // 게시글 삭제
	public int noticeupdate(BoardDTO board); // 게시글 업데이트
}

