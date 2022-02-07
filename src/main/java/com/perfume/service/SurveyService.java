package com.perfume.service;

import com.perfume.beans.PerfumeDTO;

import java.util.List;

import com.perfume.beans.NoteDTO;

public interface SurveyService {

	public List<String> SurveyNoteNumCheck(NoteDTO ndto);
	
	public List<PerfumeDTO> SurveyAccNoteResult(List<String> list);
}
