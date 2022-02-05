package com.perfume.service;

import org.springframework.stereotype.Service;

import com.perfume.beans.NoteDTO;
import com.perfume.beans.PerfumeDTO;
import com.perfume.mybatis.SurveyMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Log4j
@Service
public class SurveyServiceImpl implements SurveyService {
	
	@Setter(onMethod_=@Autowired)
	private SurveyMapper mapper;


	@Override
	public List<String> SurveyNoteNumCheck(NoteDTO ndto) {
		return mapper.noteNumCheck(ndto);
	}


	@Override
	public List<PerfumeDTO> SurveyAccNoteResult(List<String> list) {
		List<PerfumeDTO> perfumeList = new ArrayList();
		NoteDTO ndto = new NoteDTO();
		for(int i = 0; i < list.size(); i++) {
			ndto.setN_number(list.get(i));
			perfumeList.addAll(mapper.accNoteResult(ndto));
		}
		
		return perfumeList;
	}

}
