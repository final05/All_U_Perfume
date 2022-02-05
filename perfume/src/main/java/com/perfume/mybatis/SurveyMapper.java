package com.perfume.mybatis;

import com.perfume.beans.PerfumeDTO;

import java.util.List;

import com.perfume.beans.NoteDTO;


public interface SurveyMapper {

	public List<String> noteNumCheck(NoteDTO ndto);
	
	public List<PerfumeDTO> accNoteResult(NoteDTO ndto);
	
}
