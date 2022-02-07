package com.perfume.controller;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import com.perfume.beans.AdminDTO;
import com.perfume.service.AdminService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@Log4j
@RequestMapping("/admin/")
public class AdminController {
	@Autowired
	private AdminService service;
	
	// 관리자 메인
	@RequestMapping("main")
	public String main() {
		// http://localhost:8080/admin/main
		return "admin/main";
	}
	
	// 관리자 로그인
	@RequestMapping("login")
	public String login() {
		return "admin/login";
	}
	
	// 관리자 로그인 pro, login 유효성 검사
	@RequestMapping("loginPro")
	public String loginPro(AdminDTO Adto, HttpSession session) {
		if(service.adminAdminLoginCheck(Adto)==1) {
			session.setAttribute("aid", Adto.getAid());
		}
		return "admin/loginPro";
	}
	
	// 관리자 회원 강제 탈퇴 부분
	@RequestMapping("member")
	public String memeber_view(Model model, HttpSession session) {
		// http://localhost:8080/admin/member
		return "admim/member_view";
	}
	
	@RequestMapping("memeber_view")
	public String memeber_view_pro(Model model, HttpSession session) {
		return "admin/member_view_pro";
	}
}
