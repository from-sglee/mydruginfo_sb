package com.mydruginfo.repository;

import com.mydruginfo.model.AdminVO;
import com.mydruginfo.model.InsuranceCovered;
import com.mydruginfo.model.MainIngredient;
import com.mydruginfo.model.StandardCode;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;


@Mapper
public interface AdminMapper {
	
	AdminVO checkAdmin(String admin_id, String admin_pw);
    List<AdminVO> updateAdmin(AdminVO vo);
    int findAllCnt();
    List<StandardCode> AllStandardCode(int startIndex,int pageSize);
    List<InsuranceCovered> AllInsuranceCovered(int startIndex,int pageSize);
    List<MainIngredient> AllMainIngredient(int startIndex,int pageSize);
  
}
