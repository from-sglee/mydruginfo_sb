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
    StandardCodeMapper sCodeMapper;

    public StandardCode getStandardCodeBySCode(String sCode) {
        return sCodeMapper.getStandardCodeBySCode(sCode);
    }

    public List<StandardCode> getAllCity() {
        return sCodeMapper.selectAllStandardCode();
    }

    public List<StandardCode> selectStandardCodeByCompanyName(String cName) {
        return sCodeMapper.selectStandardCodeByCompanyName(cName);
    }
    public void addStandardCode(StandardCode sCode) {
    	sCodeMapper.insertStandardCode(sCode);
    }

}