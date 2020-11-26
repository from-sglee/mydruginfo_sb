package com.mydruginfo.repository;

import com.mydruginfo.model.StandardCode;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StandardCodeMapper {
	StandardCode selectStandardCodeBySCode(long standardCode);
	int selectCountAllStandardCode();
	List<StandardCode> selectAllStandardCode(int pageNo, int perPage);
	List<StandardCode> selectStandardCodeByCompanyName(String companyName);
	void insertStandardCode(StandardCode standardCode);
	List<StandardCode> selectStandardCodeLikeCName(String colName, String searchVal);

}