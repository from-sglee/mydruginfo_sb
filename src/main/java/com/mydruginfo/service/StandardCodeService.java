package com.mydruginfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public int getCountAllStandardCode() {
        return sMapper.selectCountAllStandardCode();
    }

    public int getCountLikeColumn(String colName, String searchVal) {
        return sMapper.selectCountLikeColumn(colName, searchVal);
    }
    public List<StandardCode> getStandardCodeLikeColumn(String type, String searchTxt, int page, int perPage){
    	return sMapper.selectStandardCodeLikeColumn(type, searchTxt, page, perPage);
    }
    
    public List<StandardCode> getAllStandardCode(int pageNo, int perPage) {
        return sMapper.selectAllStandardCode(pageNo, perPage);
    }
    

    public List<StandardCode> getStandardCodeByCompanyName(String companyName) {
        return sMapper.selectStandardCodeByCompanyName(companyName);
    }
    public void addStandardCode(StandardCode standardCode) {
    	sMapper.insertStandardCode(standardCode);
    }

}