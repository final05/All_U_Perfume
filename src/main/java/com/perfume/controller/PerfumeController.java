package com.perfume.controller;

import java.io.File;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.perfume.beans.FileInfo;
import com.perfume.beans.MemberDTO;
import com.perfume.beans.Pagemaker;
import com.perfume.beans.Paging;
import com.perfume.beans.PerfumeDTO;
import com.perfume.beans.ReviewDTO;
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
	
	@Autowired
	private FileInfo fileinfo;
	

	
	@RequestMapping("list")
	public String list(Model model, Paging pa, PerfumeDTO dto, ReviewDTO rdto) {
		model.addAttribute("list",service.listPage(pa));
		model.addAttribute("prank",service.perlikeRank(dto));
		model.addAttribute("rerank",service.relikeRank(rdto));
		model.addAttribute("unrerank",service.reunlikeRank(rdto));
		
		Pagemaker pagemaker = new Pagemaker();
		pagemaker.setPa(pa);
		pagemaker.setTotalCount(service.listCount());
		model.addAttribute("pa", pa);
		model.addAttribute("pageMaker", pagemaker);
		return "perfume/perfumePage";
	}
	
	@RequestMapping("search")
	public String search(Model model,PerfumeDTO dto, Paging pa, RedirectAttributes re, ReviewDTO rdto) { 
		model.addAttribute("prank",service.perlikeRank(dto));
		model.addAttribute("rerank",service.relikeRank(rdto));
		model.addAttribute("unrerank",service.reunlikeRank(rdto));
		
		String choose = dto.getChoose();
		String [] gender = dto.getC_gender();
		String [] season = dto.getC_season();
		if(choose != null && gender == null && season == null ) {
			model.addAttribute("keyword",service.keyword(dto, pa));
			
			model.addAttribute("prank",service.perlikeRank(dto));
			model.addAttribute("rerank",service.relikeRank(rdto));
			model.addAttribute("unrerank",service.reunlikeRank(rdto));
			
			Pagemaker pagemaker = new Pagemaker();
			pagemaker.setPa(pa);
			model.addAttribute("pageMaker",pagemaker);
			pagemaker.setTotalCount(service.keyCount(dto));
			model.addAttribute("pa", pa);
			
			return "perfume/perfumekPage";
		}
		else{ 
		model.addAttribute("cate",service.cate(dto,pa));		
		Pagemaker pagemaker = new Pagemaker();
		pagemaker.setPa(pa);
		model.addAttribute("pageMaker",pagemaker);
		pagemaker.setTotalCount(service.cateCount(dto));
		model.addAttribute("pa", pa);
		
		
		return "perfume/perfumePagePro";}
	}
	
	@RequestMapping("detail")
	public String detail(Model model, PerfumeDTO perfume, Paging pa,  ReviewDTO rdto) {
	
		model.addAttribute("pa",pa);	
		model.addAttribute("getDetail",service.getDetail(perfume));
	
		
		List<PerfumeDTO> detail = service.getDetail(perfume);
		PerfumeDTO a = detail.get(0);
		model.addAttribute("brand",service.brand(a.getD_number()));

		
		String top = a.getTopnote_num();
	    String heart = a.getHeartnote_num();
	    String base = a.getBasenote_num();
	    
	    if( top != null) {
	        List<String> topnote = Arrays.asList(top.split("-"));
	        model.addAttribute("topnote",service.note(topnote));

	    }

	    if( heart != null) {
	        List<String> heartnote = Arrays.asList(heart.split("-"));
	        model.addAttribute("heartnote",service.note(heartnote));

	    }

	    if( base != null) {
	        List<String> basenote = Arrays.asList(base.split("-"));
	        model.addAttribute("basenote",service.note(basenote));
	    }
		
	    model.addAttribute("getReview",service.getReview(rdto));
	   
		return "perfume/perfumeDetail";
	
	}
	
	@RequestMapping("sdetail")
	public String sdetail(Model model, PerfumeDTO perfume, Paging pa,  ReviewDTO rdto) {
		
		model.addAttribute("pa",pa);	
		model.addAttribute("getDetail",service.getDetail(perfume));
	
		
		List<PerfumeDTO> detail = service.getDetail(perfume);
		PerfumeDTO a = detail.get(0);
		model.addAttribute("brand",service.brand(a.getD_number()));

		
		String top = a.getTopnote_num();
	    String heart = a.getHeartnote_num();
	    String base = a.getBasenote_num();
	    
	    if( top != null) {
	        List<String> topnote = Arrays.asList(top.split("-"));
	        model.addAttribute("topnote",service.note(topnote));

	    }

	    if( heart != null) {
	        List<String> heartnote = Arrays.asList(heart.split("-"));
	        model.addAttribute("heartnote",service.note(heartnote));

	    }

	    if( base != null) {
	        List<String> basenote = Arrays.asList(base.split("-"));
	        model.addAttribute("basenote",service.note(basenote));
	    }
		

	   
		return "perfume/perfumesDetail";
	
	}
	
	
	@RequestMapping("review")
	public String review(
	ReviewDTO rdto, PerfumeDTO perfume, RedirectAttributes re ,HttpServletRequest request, Model model)  {
		int rchLike = service.rchLike(rdto);
		if (rchLike == 0 ) {
			service.reviewInsert(rdto);
			service.rchInsert(rdto);
		}else if(rchLike >= 1) {
	
			request.setAttribute("msg", "하나의 향수에는 한번의 리뷰만 등록 할 수 있습니다");
			request.setAttribute("p_number",perfume.getP_number());
			request.setAttribute("f_name",perfume.getF_name());
			return "perfume/alert";
		}

				
		re.addAttribute("p_number",perfume.getP_number());
		re.addAttribute("f_name",perfume.getF_name());
		
		return "redirect:detail";
	}


				
		
	@RequestMapping("perlike")
	public @ResponseBody int perlike(Model model,RedirectAttributes re, PerfumeDTO perfume, ReviewDTO rdto){

		int perlikeCh = service.perLikeCh(rdto);
		int result = 0;
		if (perlikeCh == 0){
			service.perInsert(rdto, perfume);
			service.perLike(perfume);
			result = 1;
			}else if (perlikeCh >= 1){
				result = 0;
				
			}
		
		re.addAttribute("p_number",perfume.getP_number());
		re.addAttribute("f_name",perfume.getF_name());
		
		return result;
	}
	
	
	@RequestMapping("like")
	public @ResponseBody int like(Model model,RedirectAttributes re, PerfumeDTO perfume, ReviewDTO rdto){
		int chlike = service.chLike(rdto);
		int result = 0;
		if (chlike == 0){
			service.chInsert(rdto);
			service.like(rdto);
			result = 1;
			}else if (chlike >= 1){
				result = 0;
				
			}
		
		re.addAttribute("p_number",perfume.getP_number());
		re.addAttribute("f_name",perfume.getF_name());
		
		
		return result;
	}
	
	
	
	@RequestMapping("unlike")
	public @ResponseBody int unlike(Model model,RedirectAttributes re, PerfumeDTO perfume, ReviewDTO rdto){
		int chlike = service.chLike(rdto);
		int result = 0;
		if (chlike == 0){
			service.chInsert(rdto);
			service.unLike(rdto);
			result = 1;
			}else if (chlike >= 1){
				result = 0;
				
			}
		
		re.addAttribute("p_number",perfume.getP_number());
		re.addAttribute("f_name",perfume.getF_name());
		
		
		return result;
	}

}
