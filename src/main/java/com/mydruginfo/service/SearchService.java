package com.mydruginfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mydruginfo.model.SearchVO;
import com.mydruginfo.model.StandardCode;
import com.mydruginfo.repository.SearchMapper;

@Service
@Transactional

public class SearchService {

	@Autowired
	SearchMapper searchMapper;

	public List<StandardCode> getSearch(SearchVO vo) throws Exception {
		System.out.println(vo.getSearchText());
		if (vo.getATC_code_search()) {
			List<StandardCode> list = searchMapper.getSearch("atc_code", vo.getSearchText());
			return list;
		}
		else if (vo.getCommon_name_code_search()) {
			List<StandardCode> list = searchMapper.getSearch("common_name_code", vo.getSearchText());
			return list;
		}
		else if (vo.getCompany_name_search()) {
			String searchText = vo.getSearchText();
			System.out.println(searchMapper.getSearch("company_name", searchText));
			List<StandardCode> list = searchMapper.getSearch("company_name", vo.getSearchText());
			return list;
		}
		else if (vo.getDrug_name_search()) {
			List<StandardCode> list = searchMapper.getSearch("drug_name_kr", vo.getSearchText());
			return list;
		}
		else{
			List<StandardCode> list = searchMapper.getSearch("product_code", vo.getSearchText());
			return list;
		}

	}

}
