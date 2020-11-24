package com.mydruginfo.service;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mydruginfo.model.AdminVO;
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

	public void logout(HttpSession session) {
		session.removeAttribute("userId");
		session.invalidate();
	}

}
