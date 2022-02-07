package com.perfume.controller;


import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.perfume.beans.FileInfo;
import com.perfume.beans.PerfumeDTO;
import com.perfume.beans.NoteDTO;
import com.perfume.service.PerfumeService;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.perfume.beans.FileInfo;
import com.perfume.beans.PerfumeDTO;
import com.perfume.beans.NoteDTO;
import com.perfume.service.SurveyService;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@Log4j
@RequestMapping("/survey/")
public class SurveyController {
	
	@Autowired
	private SurveyService service;
	@Autowired
	private PerfumeService service2;
	
	@RequestMapping("surveyStart")
	public String surveyStart(){
		return "survey/surveyStart";
	}
	
	@RequestMapping("accSurvey")
	public String accSurvey(){
		return "survey/accSurvey";
	}
	
	@RequestMapping("absSurvey")
	public String absSurvey(){
		return "survey/absSurvey";
	}
	
	@RequestMapping("accResult")
	public String accResult(NoteDTO ndto, Model model){
		List<String> accList = service.SurveyNoteNumCheck(ndto);
		//model.addAttribute("n_number", accList);
		
		System.out.println(accList);
		
		List<PerfumeDTO> perfumeList = service.SurveyAccNoteResult(accList);
		model.addAttribute("Tnote",perfumeList);
		return "survey/accResult";
	}
	
}
