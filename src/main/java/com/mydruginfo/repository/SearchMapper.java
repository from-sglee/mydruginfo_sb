package com.mydruginfo.repository;

import java.util.List;

import com.mydruginfo.model.StandardCode;

public interface SearchMapper {
	
	List<StandardCode> getSearch(String checkbox, String keyword);

}
