package com.perfume.mybatis;

import com.perfume.beans.AdminDTO;
import com.perfume.beans.MemberDTO;

public interface AdminMapper {
	
	public int adminLoginCheck (AdminDTO adminDTO);
	
	// 관리자 회원 강제 탈퇴시 해당 회원이 있는지 체크하는 메서드
	public String member_view(MemberDTO memberdto); 
}
