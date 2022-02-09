package com.perfume.controller;


import com.perfume.beans.BoardDTO;
import com.perfume.beans.Pagemaker;
import com.perfume.beans.Paging;
import com.perfume.beans.RE_BoardDTO;
import com.perfume.controller.NoticeController;
import com.perfume.service.NoticeBoardService;
import com.perfume.service.Q_ABoardService;
import com.perfume.service.RecommendationBoardService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.MDC;
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
public class Q_AController {
	
	@Setter(onMethod_=@Autowired)
	private Q_ABoardService q_aservice;
	

	// Q_A 내용 보기 + 조뢰수 증가 + 페이징 처리
	@RequestMapping("q_a/q_aContent")
	public String content(Model model, RedirectAttributes rttr, BoardDTO boardDTO, int b_number) {
		model.addAttribute("boardDTO", q_aservice.q_aContent(boardDTO));
		q_aservice.q_areadcount(b_number);
		return "board/q_a/q_aContent";
	}
	
	// Q_A 글 작성 Form
	@RequestMapping("q_a/write")
	public String writeForm(Model model, BoardDTO boardDTO) {
		return "board/q_a/write";
	}
		
	// Q_A 글 작성 Pro
	@RequestMapping("q_a/writePro") 
	public String writePro(Model model, BoardDTO boardDTO) {
		model.addAttribute("result", q_aservice.q_ainsert(boardDTO));
		return "board/q_a/writePro";	
	}
	
	// Q_A 글 수정 Form
	
	@RequestMapping("q_a/update")
	public String updateForm(Model model, BoardDTO boardDTO) {
		model.addAttribute("boardDTO", q_aservice.q_aupdate(boardDTO));
		return "board/q_a/update";
	}
	
	// Q_A 글 수정 Pro
	@RequestMapping("q_a/updatePro")
	public String updatePro(Model model, BoardDTO boardDTO) {
		model.addAttribute("result", q_aservice.q_aupdate(boardDTO));
		return "board/q_a/updatePro";
	}
	
	// Q_A 글 삭제
	@RequestMapping("q_a/delete") 
	public String delete(Model model, BoardDTO boardDTO) {
		return "board/q_a/delete";
	}
	
	// Q_A 글 삭제
	@RequestMapping("q_a/deletePro") 
	public String deletePro(Model model, String b_number) {
		model.addAttribute("result", q_aservice.q_adelete(b_number));
		return "board/q_a/deletePro";
	}
	
	// Q_A 처리
	@RequestMapping("q_a/list")
	public String list(Model model, Paging pa, BoardDTO boardDTO) {
		model.addAttribute("q_a_list",q_aservice.selectQ_ABoard(pa));
		Pagemaker pagemaker = new Pagemaker(); // 객체생성
		pagemaker.setPa(pa);
		pagemaker.setTotalCount(q_aservice.q_areadcount(0));
		model.addAttribute("pageMaker", pagemaker);
		return "board/q_a/q_aBoardPage";
	}
	
	// Q_A 게시판 게시글 답변
	@RequestMapping("q_a/boardReply")
	public String boardReply(HttpServletRequest request, HttpServletResponse response) {
		return "board/q_a/ReBoardWriteForm";
	}
	
	@RequestMapping("q_a/insertBoardReply")
	public String insertBoardReply (HttpServletRequest request, HttpServletResponse response, RE_BoardDTO reboardDTO) {
		return "board/q_a/ReBoardWritePro";
	}
}
