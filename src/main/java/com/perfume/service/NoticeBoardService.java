package com.perfume.service;

import java.util.List;

import com.perfume.beans.BoardDTO;

public interface NoticeBoardService {
	public List<BoardDTO> getList(); // 게시판 글 목록 리턴할 메서드
	public int noticeinsert(BoardDTO board);
	public BoardDTO noticeread(int b_number);
	public int noticedelete(int b_number);
	public int noticeupdate(BoardDTO board);
}

