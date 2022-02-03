package com.perfume.mybatis;

import java.util.List;
import java.util.Map;

import com.perfume.beans.Paging;
import com.perfume.beans.PerfumeDTO;

public interface PerfumeMapper {
	
	public List<PerfumeDTO> getDetail(PerfumeDTO perfume);  //향수 상세페이지
	
	public int listCount(); //게시물 갯수
	
	public List<PerfumeDTO> listPage(Paging pa); //페이징처리 포함한 리스트
	
	public List<PerfumeDTO> cate(PerfumeDTO perfume);

}
