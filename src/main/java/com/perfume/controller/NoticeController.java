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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.Data;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;


@Controller
@Log4j
@Slf4j
@RequestMapping("perfume")
public class NoticeController {
	
	@Setter(onMethod_=@Autowired)
	private NoticeBoardService noticeservice;
	
	@RequestMapping("notice")
	public String NoticeList(Model model) {
		// http://localhost:8080/perfume/notice
		log.info("게시판 목록 페이지 진입");
		model.addAttribute("list", noticeservice.getList());
		log.info("---------------dpfos;'fk'sdkf';skdfl;sf l;d-------");
		return "board/notice/notice";		
	}

	// 공지 내용 보기 + 조뢰수 증가
	@RequestMapping("noticeContent")
	public String content(Model model, RedirectAttributes rttr, BoardDTO boardDTO) {
		log.info("============/borad/readcount?=b_number"+boardDTO.getB_number());
		// noticeservice.noticeContent(boardDTO.getB_number());
		// rttr.addAttribute("b_number", boardDTO.getB_number());
		model.addAttribute("boardDTO", noticeservice.noticeContent(boardDTO));
		// log.info("content" + boardDTO.getContent());
		return "board/notice/noticeContent";
	}
	
	// 공지 글 작성 Form
	@RequestMapping("write")
	public String writeForm(Model model, BoardDTO boardDTO) {
		log.info("============/borad/write");
		log.info("boardDTO =" + boardDTO);
		return "board/notice/write";
	}
		
	// 공지 글 작성 Pro
	@RequestMapping("writePro") 
	public String writePro(Model model, BoardDTO boardDTO) {
		log.info("============/borad/writePro");
		model.addAttribute("result", noticeservice.noticeinsert(boardDTO));
		return "board/notice/writePro";	
	}
	
	// 공지 글 수정 Form
	
	@RequestMapping("update")
	public String updateForm(Model model, BoardDTO boardDTO) {
		log.info("==============board/notice/updateForm=="+boardDTO.getB_number());
		return "board/notice/update";
	}
	
	// 공지 글 수정 Pro
	@RequestMapping("updatePro")
	public String updatePro(Model model, BoardDTO boardDTO) {
		log.info("==============board/notice/updatePro"+boardDTO.getB_number());
		model.addAttribute("result", noticeservice.noticeupdate(boardDTO));
		return "board/notice/updatePro";
	}
	
	// 공지 글 삭제
	@RequestMapping("delete") 
	public String delete(Model model, BoardDTO boardDTO) {
		log.info("==============board/notice/updatePro"+boardDTO.getB_number());
		return "board/notice/delete";
	}
	
	// 공지 글 삭제
	@RequestMapping("deletePro") 
	public String deletePro(Model model, int b_number) {
		// log.info("==============board/notice/updatePro"+boardDTO.getB_number());
		model.addAttribute("result", noticeservice.noticedelete(b_number));
		return "board/notice/deletePro";
	}
}
