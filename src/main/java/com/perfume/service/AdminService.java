package com.perfume.service;

import com.perfume.beans.AdminDTO;
import com.perfume.beans.MemberDTO;

public interface AdminService {
	// 관리자 로그인 시 유효성 검사
	public int adminAdminLoginCheck (AdminDTO adminDTO);
	
	// 관리자 회원 강제 탈퇴시 해당 회원이 있는지 체크하는 메서드
	public String member_view(MemberDTO memberdto); 
}
