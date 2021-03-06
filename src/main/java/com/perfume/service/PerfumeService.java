package com.perfume.service;

import java.util.List;
import java.util.Map;

import com.perfume.beans.BrandDTO;
import com.perfume.beans.NoteDTO;
import com.perfume.beans.Paging;
import com.perfume.beans.PerfumeDTO;
import com.perfume.beans.ReviewDTO;

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
	
	//브랜드 가져오
	public BrandDTO brand(String d_number);
		
	//노트정보 가져오기 
	public  List<NoteDTO> note(List<String> list);
	
	//리뷰 입력
	public int reviewInsert(ReviewDTO rdto);
	
	//리뷰입력시  중복방지 입력
	public int rchInsert(ReviewDTO rdto); 
	
	//리뷰 중복방지
	public int rchLike(ReviewDTO rdto);
	
	//리뷰가져오기
	public List<ReviewDTO> getReview(ReviewDTO rdto);
	
	
	
	
	public int reviewImg(ReviewDTO rdto);
	
	//향수 좋아요 중복 방지 입력
	public int perInsert(ReviewDTO rdto, PerfumeDTO dto);
	
	//향수 좋아요 중복 방지 체크
	public int perLikeCh(ReviewDTO rdto);
	
	//향수 좋아요
	public int perLike(PerfumeDTO dto);
	
	//향수 좋아요 랭킹
	public List<PerfumeDTO> perlikeRank(PerfumeDTO dto);

	
	
	
	//리뷰 좋아요, 싫어요 중복방지입력 
	public int chInsert(ReviewDTO rdto);
	
	//리뷰 좋아요, 싫어요 중복방지 체크
	public int chLike(ReviewDTO rdto);
	
	//리뷰 좋아요
	public int like(ReviewDTO rdto);
	
	//리뷰 싫어요
	public int unLike(ReviewDTO rdto);
	
	//리뷰 좋아요 랭킹
	public List<PerfumeDTO> relikeRank(ReviewDTO rdto);
		
	//리뷰 싫어요 랭킹
	public List<PerfumeDTO> reunlikeRank(ReviewDTO rdto);
	
	
	
	
	

}
