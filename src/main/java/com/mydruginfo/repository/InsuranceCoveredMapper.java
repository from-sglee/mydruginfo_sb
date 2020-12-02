package com.mydruginfo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mydruginfo.model.InsuranceCovered;

@Mapper
public interface InsuranceCoveredMapper {
	InsuranceCovered selectInsuranceInfoByPCode(String pCode);
	List<InsuranceCovered> selectAllInsuranceInfo();
	List<InsuranceCovered> selectInsuranceInfoByDrugName(String drugName);
	void insertInsuranceInfo(InsuranceCovered standardCode);

}
