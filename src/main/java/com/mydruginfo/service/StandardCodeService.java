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
    StandardCodeMapper standardCodeMapper;

    public StandardCode getStandardCodeBySCode(long standardCode) {
        return standardCodeMapper.selectStandardCodeBySCode(standardCode);
    }

    public List<StandardCode> getAllStandardCode() {
        return standardCodeMapper.selectAllStandardCode();
    }
    

    public List<StandardCode> selectStandardCodeByCompanyName(String companyName) {
        return standardCodeMapper.selectStandardCodeByCompanyName(companyName);
    }
    public void addStandardCode(StandardCode standardCode) {
    	standardCodeMapper.insertStandardCode(standardCode);
    }

}