package com.perfume.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfume.beans.Paging;
import com.perfume.beans.PerfumeDTO;
import com.perfume.mybatis.PerfumeMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Log4j
@Service
public class PerfumeServiceImpl implements PerfumeService{
	
	@Setter(onMethod_=@Autowired)
	private PerfumeMapper mapper;

	@Override
	public List<PerfumeDTO> getDetail(PerfumeDTO perfume )  {
		return mapper.getDetail(perfume);
	}

	@Override
	public int listCount() {
		return mapper.listCount();
	}

	@Override
	public List<PerfumeDTO> listPage(Paging pa) {
		return mapper.listPage(pa);
		
	}

	@Override
	public List<PerfumeDTO> cate(PerfumeDTO perfume) {
		// String [] arr = ${}
		return mapper.cate(perfume);
	}


	
	

}
