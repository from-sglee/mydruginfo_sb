package com.mydruginfo.repository;

import com.mydruginfo.model.StandardCode;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StandardCodeMapper {
	StandardCode selectStandardCodeBySCode(long standardCode);
	int selectCountAllStandardCode();
	int selectCountLikeColumn(String colName, String searchVal);
	List<StandardCode> selectStandardCodeLikeColumn(String colName, String searchVal, int startIndex, int pageSize);
	List<StandardCode> selectAllStandardCode(int startIndex, int pageSize);
	List<StandardCode> selectStandardCodeByCompanyName(String companyName);
	void insertStandardCode(StandardCode standardCode);
	void deleteStandardCode(long sCode);

}