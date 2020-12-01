package com.mydruginfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mydruginfo.model.InsuranceCovered;
import com.mydruginfo.model.MainIngredient;
import com.mydruginfo.model.StandardCode;
import com.mydruginfo.repository.StandardCodeMapper;

@Service
@Transactional
public class StandardCodeService {

    @Autowired
    StandardCodeMapper sMapper;

    public StandardCode getStandardCodeBySCode(long standardCode) {
        return sMapper.selectStandardCodeBySCode(standardCode);
    }
    
    public InsuranceCovered getStandardCodeByICCode(String icCode) {
        return sMapper.selectStandardCodeByICCode(icCode);
    }
    
    public MainIngredient getStandardCodeByMICode(String miCode) {
        return sMapper.selectStandardCodeByMICode(miCode);
    }

    public int getCountAllStandardCode() {
        return sMapper.selectCountAllStandardCode();
    }

    public int getCountLikeColumn(String colName, String searchVal) {
        return sMapper.selectCountLikeColumn(colName, searchVal);
    }
    
    public List<StandardCode> getStandardCodeLikeColumn(String type, String searchTxt, int startIndex, int pageSize){
    	return sMapper.selectStandardCodeLikeColumn(type, searchTxt, startIndex, pageSize);
    }
    
    public List<StandardCode> getAllStandardCode(int startIndex, int pageSize) {
        return sMapper.selectAllStandardCode(startIndex, pageSize);
    }
    

    public List<StandardCode> getStandardCodeByCompanyName(String companyName) {
        return sMapper.selectStandardCodeByCompanyName(companyName);
    }
    
    public void addStandardCode(StandardCode standardCode) {
    	sMapper.insertStandardCode(standardCode);
    }
    public void delStandardCodeBySCode(long sCode,String value) {
    	sMapper.deleteStandardCode(sCode,value);
    }

}