package com.perfume.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.perfume.beans.Paging;
import com.perfume.beans.PerfumeDTO;

public interface PerfumeMapper {
	
	public List<PerfumeDTO> getDetail(PerfumeDTO perfume);  //향수 상세페이지
	
	public int listCount(); //게시물 갯수
	
	public List<PerfumeDTO> listPage(Paging pa); //페이징처리 포함한 리스트
	
	public List<PerfumeDTO> cate(@Param("c_gender") String[] gender, @Param("c_season") String[] season, 
			@Param("rowStart") int rowStart, @Param("rowEnd") int rowEnd); //성별, 계절 검색
	
	
	public List<PerfumeDTO> keyword(@Param("keyword") String keyword, @Param("choose") String choose, 
			@Param("rowStart") int rowStart, @Param("rowEnd") int rowEnd) ; //키워드 검색
	
	public int cateCount(@Param("c_gender") String[] c_gender, @Param("c_season") String[] c_season); //검색후 게시물 갯수
	
	public int keyCount(@Param("keyword") String keyword, @Param("choose") String choose); //키워드 검색 후 게시물 갯수

}
