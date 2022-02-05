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
	
	@RequestMapping("main")
	public String main() {
		return "admin/main";
	}
	
	@RequestMapping("login")
	public String login() {
		return "admin/login";
	}

	@RequestMapping("loginPro")
	public String loginPro(AdminDTO Adto, HttpSession session) {
		if(service.adminAdminLoginCheck(Adto)==1) {
			session.setAttribute("aid", Adto.getAid());
		}
		return "admin/loginPro";
	}
	
}
