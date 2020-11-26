package com.mydruginfo.service;


import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mydruginfo.model.AdminVO;
import com.mydruginfo.model.StandardCode;
import com.mydruginfo.repository.AdminMapper;

@Service
@Transactional
public class AdminService {

	@Autowired
	AdminMapper adminMapper;
	

	public boolean checkAdmin(String admin_id, String admin_pw) {
		
		AdminVO vo = adminMapper.checkAdmin(admin_id, admin_pw);
		boolean result = false;
		
		if(vo == null) {
			return result;
		}
		
		else {
			result = true;
			return result;
		}
		
		
	}

	public boolean updateAdmin(AdminVO vo) {
		
		if(adminMapper.checkAdmin(vo.getAdmin_id(),vo.getAdmin_pw()).getAdmin_id()!=null){
			adminMapper.updateAdmin(vo);
			return true;
		}
		else {
			return false;
		}
	}
	
	public int findAllCnt() {
		return adminMapper.findAllCnt();
	}
	
	public List<StandardCode> AllStandardCode(int startIndex, int pageSize){
		
		return adminMapper.AllStandardCode(startIndex,pageSize);
		
	}
	

	public void logout(HttpSession session) {
		session.removeAttribute("admin_id");
		session.invalidate();
	}

}
