package com.mydruginfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mydruginfo.model.InsuranceCovered;
import com.mydruginfo.repository.InsuranceCoveredMapper;

@Service
@Transactional
public class InsuranceCoveredService {

    @Autowired
    InsuranceCoveredMapper iMapper;

    public InsuranceCovered getInsuranceInfoByPCode(String pCode) {
        return iMapper.selectInsuranceInfoByPCode(pCode);
    }

    public List<InsuranceCovered> getAllInsuranceInfo() {
        return iMapper.selectAllInsuranceInfo();
    }

    public List<InsuranceCovered> getInsuranceInfoByDrugName(String drugName) {
        return iMapper.selectInsuranceInfoByDrugName(drugName);
    }
    public void addInsuranceInfo(InsuranceCovered insuranceInfo) {
    	iMapper.insertInsuranceInfo(insuranceInfo);
    }
}
