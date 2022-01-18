package com.perfume.controller;

import com.perfume.beans.BoardDTO;
import com.perfume.controller.NoticeController;
import com.perfume.service.NoticeBoardService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Data;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
@RequestMapping("perfume")
public class NoticeController {
	
	@Setter(onMethod_=@Autowired)
	private NoticeBoardService noticeservice;
	private BoardDTO boardDTO;
	
	@RequestMapping("notice")
	public String NoticeList(Model model) {
		// http://localhost:8080/perfume/notice
		log.info("게시판 목록 페이지 진입");
		model.addAttribute("list", noticeservice.getList());
		log.info("---------------dpfos;'fk'sdkf';skdfl;sf l;d-------");
		return "board/notice";		
	}

	@RequestMapping("noticeContent")
	public String content() {
		return "board/noticeContent";
	}
	
	
}
