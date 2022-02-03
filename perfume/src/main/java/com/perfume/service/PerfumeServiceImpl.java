package com.perfume.service;

import java.util.ArrayList;
import java.util.Arrays;
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
	public List<PerfumeDTO> getDetail(PerfumeDTO perfume)  {
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
	public List<PerfumeDTO> cate(PerfumeDTO perfume, Paging pa) {
		List<PerfumeDTO> resultList = new ArrayList();
		String [] tt = perfume.getC_season();
		String [] str = perfume.getC_gender();
	
		
		 if (str != null && tt ==null) {
			for(String s : str) {
					String gender = (String) s;
					perfume.setGender(gender);
					perfume.setSeason("5");
					List<PerfumeDTO> searchList = mapper.cate(Integer.parseInt(perfume.getGender()),
							perfume.getSeason(),
							pa.getRowStart(),
							pa.getRowEnd());
								for(PerfumeDTO dto : searchList) {
										resultList.add(dto);

								}
						}
				}
		
		
		if(tt != null && str==null) {
			for(String t : tt) {
				String season = (String) t;
				perfume.setSeason(season);
				perfume.setGender("5");
				List<PerfumeDTO> searchList = mapper.cate(Integer.parseInt(perfume.getGender()),
															perfume.getSeason(),
															pa.getRowStart(),
															pa.getRowEnd());
				for(PerfumeDTO dto : searchList) {
					resultList.add(dto);
			
				}
				
			}
			
		}
		
		return resultList;
	}

	@Override
	public List<PerfumeDTO> keyword(PerfumeDTO perfume) {
		return mapper.keyword(perfume);
	}

	@Override
	public int cateCount(PerfumeDTO perfume) {
		int result = 0;
		String [] tt = perfume.getC_season();
		String [] str = perfume.getC_gender();
		
		if(tt != null && str != null) {
		for(String s : str) {
			String gender = (String) s;
			perfume.setGender(gender);
			
			
			for(String t : tt) {
				String season = (String) t;
				perfume.setSeason(season);
				
				result += mapper.cateCount(Integer.parseInt(perfume.getGender()), perfume.getSeason());
				
			}
		}
	}	
		if(str != null && tt ==null) {
			for(String s : str) {
				String gender = (String) s;
				perfume.setGender(gender);
				perfume.setSeason("5");
				result += mapper.cateCount(Integer.parseInt(perfume.getGender()), perfume.getSeason());
		}
			}
		
		if(tt != null && str ==null) {
			for(String t : tt) {
				String season = (String) t;
				perfume.setSeason(season);
				perfume.setGender("5");
				
				result += mapper.cateCount(Integer.parseInt(perfume.getGender()), perfume.getSeason());
				
			}
			
		}
		return result;
}


	
	

}
