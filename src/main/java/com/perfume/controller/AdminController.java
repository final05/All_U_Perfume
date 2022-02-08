package com.perfume.controller;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.perfume.beans.FileInfo;
import com.perfume.beans.MemberDTO;
import com.perfume.beans.Pagemaker;
import com.perfume.beans.Paging;
import com.perfume.beans.AdminDTO;
import com.perfume.beans.BoardDTO;
import com.perfume.service.AdminService;
import com.perfume.service.NoticeBoardService;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@Log4j
@RequestMapping("admin")
public class AdminController {
	@Autowired
	private AdminService service;
	@Autowired
	private NoticeBoardService noticeservice;

	
	// 관리자 메인
	@RequestMapping("main")
	public String main() {
		// http://localhost:8080/admin/main
		return "admin/main";
	}
	
	// 관리자 로그인
	@RequestMapping("login")
	public String login(AdminDTO Adto, HttpSession session) {
		session.setAttribute("aid", Adto.getAid());
		return "admin/login";
	}

	// 관리자 로그인 pro, login 유효성 검사
	@RequestMapping("loginPro")
	public String loginPro(AdminDTO Adto, HttpSession session) {
		if(service.adminAdminLoginCheck(Adto)==1) {
			session.setAttribute("aid", Adto.getAid());
			log.info("로그인 pro 세션 확인 ::::::::: " + Adto.getAid());
		}
		return "admin/loginPro";
	}

	// 관리자 회원 강제 탈퇴 부분
	@RequestMapping("member_admin")
	public String memeber_view(Model model, HttpSession session, MemberDTO memberdto, AdminDTO Adto) {
		// http://localhost:8080/admin/member_delete
		// session.getAttribute("aid");
		log.info("강제 탈퇴 jsp aid세션 확인" + session.getAttribute("aid"));
		return "admin/member_admin";
	}
	
	// 관리자 회원 강제 탈퇴 pro 세션 넘기기
	@RequestMapping("member_admin_pro")
	public String memeber_delete_pro(Model model, MemberDTO memberdto, HttpSession session, AdminDTO Adto) {
		log.info("강탈 시킬 아이디 ==== " + memberdto.getId());
		log.info("강제 탈퇴 jsp aid세션 확인" + session.getAttribute("aid"));
		// session.getAttribute("aid");
		model.addAttribute("result", service.member_delete(memberdto));
		return "admin/member_admin_pro";
	}
	
	
	// 페이징 처리
	@RequestMapping("notice_admin")
	public String list(Model model, Paging pa, BoardDTO boardDTO,HttpSession session, AdminDTO Adto) {
		log.info("==========notice admin======" + boardDTO.getSubject());
		log.info("list jsp aid세션 확인" + session.getAttribute("aid"));
		model.addAttribute("list",service.selectNoticeBoard(pa));
		Pagemaker pagemaker = new Pagemaker(); // 객체생성
		pagemaker.setPa(pa);
		pagemaker.setTotalCount(service.countNoticeBoard());
		model.addAttribute("pageMaker", pagemaker);
		log.info("리스트 aid세션 확인" + Adto.getAid());
		return "admin/notice_admin";
	}
	
	// 게시글 선택 삭제
	@RequestMapping("notice_admin_delete")
	public @ResponseBody String noticedelete_2(HttpServletRequest request) {
		// http://localhost:8080/admin/notice_admin_delete
		// log.info("동작은 하느냐 ===================" + b_number);
		log.info("서비스 확인======="+noticeservice);
		String[] ajaxMsg = request.getParameterValues("valueArr");
		log.info("체크 확인=="+ajaxMsg);
		log.info("체크 확인=="+ajaxMsg.length);
		int size = ajaxMsg.length;
		for (int i=0; i<size; i++) {
			noticeservice.noticedelete(ajaxMsg[i]);
		}
		return "1";
	}
	

}