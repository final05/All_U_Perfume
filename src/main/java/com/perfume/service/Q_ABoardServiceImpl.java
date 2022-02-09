package com.perfume.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfume.beans.BoardDTO;
import com.perfume.beans.Paging;
import com.perfume.beans.RE_BoardDTO;
import com.perfume.mybatis.Q_ABoardMapper;

import lombok.Setter;

@Service
public class Q_ABoardServiceImpl implements Q_ABoardService {
	
	@Setter(onMethod_=@Autowired)
	private Q_ABoardMapper qamapper;
	
	@Override
	public int q_ainsert(BoardDTO board) {
		// TODO Auto-generated method stub
		return qamapper.q_ainsert(board);
	}

	@Override
	public BoardDTO q_aContent(BoardDTO board) {
		// TODO Auto-generated method stub
		return qamapper.q_aContent(board);
	}

	@Override
	public int q_adelete(String b_number) {
		// TODO Auto-generated method stub
		return qamapper.q_adelete(b_number);
	}

	@Override
	public int q_aupdate(BoardDTO board) {
		// TODO Auto-generated method stub
		return qamapper.q_aupdate(board);
	}

	@Override
	public int q_areadcount(int b_number) {
		// TODO Auto-generated method stub
		return qamapper.q_areadcount(b_number);
	}

	@Override
	public int countQ_ABoard() {
		// TODO Auto-generated method stub
		return qamapper.countQ_ABoard();
	}

	@Override
	public List<BoardDTO> selectQ_ABoard(Paging pa) {
		// TODO Auto-generated method stub
		return qamapper.selectQ_ABoard(pa);
	}

	@Override
	public int q_a_re_insert(RE_BoardDTO reboard) {
		// TODO Auto-generated method stub
		return qamapper.q_a_re_insert(reboard);
	}

}
