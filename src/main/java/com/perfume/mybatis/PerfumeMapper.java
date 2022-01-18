package com.perfume.mybatis;

import java.util.List;
import java.util.Map;

import com.perfume.beans.PerfumeDTO;

public interface PerfumeMapper {
	
	public List<PerfumeDTO> getList();
	
	public int listCount();

}
