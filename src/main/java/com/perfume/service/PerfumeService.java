package com.perfume.service;

import java.util.List;
import java.util.Map;

import com.perfume.beans.Paging;
import com.perfume.beans.PerfumeDTO;

public interface PerfumeService {
	
	//향수 상세페이지 
	public List<PerfumeDTO> getDetail(PerfumeDTO perfume);
	
	//향수 리스트 갯수
	public int listCount();
	
	//페이징처리 포함한 리스트
	public List<PerfumeDTO> listPage(Paging pa); 
	
	//성별, 계절 검색 
	public List<PerfumeDTO> cate(PerfumeDTO perfume, Paging pa);
	
	//키워드 검색 
	public List<PerfumeDTO> keyword(PerfumeDTO perfume,Paging pa);
	
	//성별, 계절 검색 후 게시물 갯수
	public int cateCount(PerfumeDTO perfume);
	
	//키워드 검색 후 게시물 갯수
	public int keyCount(PerfumeDTO perfume);
	

}
