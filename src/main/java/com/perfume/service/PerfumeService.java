package com.perfume.service;

import java.util.List;
import java.util.Map;

import com.perfume.beans.PerfumeDTO;

public interface PerfumeService {
	
	//향수 리스트 가져오기
	public List<PerfumeDTO> getList();
	
	//향수 리스트 갯수
	public int listCount();
	
	

}
