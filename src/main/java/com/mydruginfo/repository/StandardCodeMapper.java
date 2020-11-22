package com.mydruginfo.repository;

import com.mydruginfo.model.StandardCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StandardCodeMapper {
	StandardCode getStandardCodeBySCode(@Param("standard_code") String scode);
    List<StandardCode> selectAllStandardCode();
    List<StandardCode> selectStandardCodeByCompanyName(@Param("company_name") String cName);
    void insertStandardCode(StandardCode scode);

}