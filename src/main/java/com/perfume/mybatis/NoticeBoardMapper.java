package com.perfume.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.perfume.beans.BoardDTO;



public interface NoticeBoardMapper {
	
	// @Select("select * from tbl_board where boardnum='3' ")
	// 보통 위의 코드는 mapper.xml 파일에서 코드가 짜여지기 때문에 mapper.java 파일에는 쓰지 않는다.
	public List<BoardDTO> getList(); // 게시판 글 목록 리턴할 메서드
	
	public int noticeinsert(BoardDTO board);
	
	public BoardDTO noticeReadCount(int b_number);
	
	public int noticedelete(int b_number);
	
	public int noticeupdate(BoardDTO board);
}
