package com.perfume.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.perfume.beans.Pagemaker;
import com.perfume.beans.Paging;
import com.perfume.beans.PerfumeDTO;
import com.perfume.service.PerfumeService;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Log4j
@Controller
@RequestMapping("/main/")
public class PerfumeController {
	
	@Autowired
	private PerfumeService service;
	
	@RequestMapping("list")
	public String list(Model model, Paging pa) {
		model.addAttribute("list",service.listPage(pa));
		Pagemaker pagemaker = new Pagemaker();
		pagemaker.setPa(pa);
		pagemaker.setTotalCount(service.listCount());
		
		model.addAttribute("pageMaker", pagemaker);
		log.info("=====list====");
		return "perfume/perfumePage";
	}
	
	@RequestMapping("search")
	public String search(Model model,PerfumeDTO dto, HttpServletRequest req, @RequestParam String c_gender) { 
		
		String [] result = req.getParameterValues("c_gender");
		model.addAttribute("cate",service.cate(dto));
		log.warn(c_gender); 
		 
		return "perfume/perfumePagePro";
	}
	
	@RequestMapping("detail")
	public String detail(Model model, PerfumeDTO perfume) {	
	model.addAttribute("getDetail",service.getDetail(perfume));	
	
		return "perfume/perfumeDetail";
	}
}
