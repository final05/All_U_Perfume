package com.perfume.service;

import com.perfume.beans.AdminDTO;
import com.perfume.beans.MemberDTO;
import com.perfume.mybatis.AdminMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Log4j
@Service
public class AdminServiceImpl implements AdminService{
	SqlSession sqlSession;
	@Setter(onMethod_=@Autowired)
	private AdminMapper mapper;

	@Override
	public int adminAdminLoginCheck(AdminDTO adminDTO) {
		return mapper.adminLoginCheck(adminDTO);
	}

	@Override
	public String member_view(MemberDTO memberdto) {
		sqlSession.delete("member_view", memberdto);
		return mapper.member_view(memberdto);
	}
	
	
}
