package com.perfume.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfume.beans.BoardDTO;
import com.perfume.mybatis.NoticeBoardMapper;

import lombok.Setter;

@Service
public class NoticeBoardServiceImpl implements NoticeBoardService {
	
	@Setter(onMethod_=@Autowired)
	private NoticeBoardMapper noticemapeer;
	

	@Override
	public List<BoardDTO> getList() {
		// TODO Auto-generated method stub
		return noticemapeer.getList();
	}

	@Override
	public int noticeinsert(BoardDTO board) {
		// TODO Auto-generated method stub
		return noticemapeer.noticeinsert(board);
	}

	@Override
	public BoardDTO noticeread(int b_number) {
		// TODO Auto-generated method stub
		return noticemapeer.noticeread(b_number);
	}

	@Override
	public int noticedelete(int b_number) {
		// TODO Auto-generated method stub
		return noticemapeer.noticedelete(b_number);
	}

	@Override
	public int noticeupdate(BoardDTO board) {
		// TODO Auto-generated method stub
		return noticemapeer.noticeupdate(board);
	}

}