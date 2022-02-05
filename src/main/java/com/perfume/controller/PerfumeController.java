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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		model.addAttribute("pa", pa);
		model.addAttribute("pageMaker", pagemaker);
		return "perfume/perfumePage";
	}
	
	@RequestMapping("search")
	public String search(Model model,PerfumeDTO dto, Paging pa, RedirectAttributes re, HttpServletRequest ht) { 
		String choose = dto.getChoose();
		String [] gender = dto.getC_gender();
		String [] season = dto.getC_season();
		if(choose != null && gender == null && season == null ) {
			model.addAttribute("keyword",service.keyword(dto, pa));
			Pagemaker pagemaker = new Pagemaker();
			pagemaker.setPa(pa);
			model.addAttribute("pageMaker",pagemaker);
			pagemaker.setTotalCount(service.keyCount(dto));
			model.addAttribute("pa", pa);
			
			re.addAttribute("page",pa.getPage());
			re.addAttribute("perPageNum",pa.getPerPageNum());
			re.addAttribute("keyword",dto.getKeyword());
			
			return "perfume/perfumekPage";
		}
		else{ 
		model.addAttribute("cate",service.cate(dto,pa));		
		Pagemaker pagemaker = new Pagemaker();
		pagemaker.setPa(pa);
		model.addAttribute("pageMaker",pagemaker);
		pagemaker.setTotalCount(service.cateCount(dto));
		model.addAttribute("pa", pa);
		
		
		re.addAttribute("page",pa.getPage());
		re.addAttribute("perPageNum",pa.getPerPageNum());
		re.addAttribute("gender",service.cate(dto, pa));
		re.addAttribute("season",dto.getSeason());
		
		
		return "perfume/perfumePagePro";}
	}
	
	@RequestMapping("detail")
	public String detail(Model model, PerfumeDTO perfume, Paging pa, RedirectAttributes re) {
	
	model.addAttribute("pa",pa);	
	model.addAttribute("getDetail",service.getDetail(perfume));
	
	re.addAttribute("page",pa.getPage());
	re.addAttribute("perPageNum",pa.getPerPageNum());
	re.addAttribute("gender",perfume.getGender());
	re.addAttribute("season",perfume.getSeason());
		return "perfume/perfumeDetail";
	}
	
	@RequestMapping("review")
	public String review() {
		
		return "redirect:/perfume/perfumeDetail";
	}
}
