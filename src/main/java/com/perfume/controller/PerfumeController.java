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
	public String list(Model model) {
		List<PerfumeDTO> list = service.getList();
		log.info("=====list====");
		model.addAttribute("list",list);
		return "perfume/perfumePage";
	}
	
	@RequestMapping("search")
	public String search(Model model) {
		 
		return "perfume/perfumePagePro";
	}
	
	@RequestMapping("detail")
	public String detail() {
		log.info("detail");
		return "perfume/perfumeDetail";
	}

}
