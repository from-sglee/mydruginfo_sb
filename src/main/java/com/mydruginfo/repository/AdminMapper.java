package com.mydruginfo.repository;

import com.mydruginfo.model.AdminVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;


@Mapper
public interface AdminMapper {
	
	AdminVO checkAdmin(String admin_id, String admin_pw);
    List<AdminVO> updateAdmin(AdminVO vo);
    
}