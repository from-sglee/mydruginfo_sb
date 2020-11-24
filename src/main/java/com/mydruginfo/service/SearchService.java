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
		if (vo.getAll_search()) {

			List<StandardCode> list = searchMapper.getSearch("ALL_TAB_COLUMNS", vo.getKeyword());

			return list;
		} else {
			List<StandardCode> list = null;
			if (vo.getATC_code_search()) {
				list.addAll(searchMapper.getSearch("atc_code", vo.getKeyword()));
			}
			if (vo.getCommon_name_code_search()) {
				list.addAll(searchMapper.getSearch("common_name_code", vo.getKeyword()));
			}
			if (vo.getCompany_name_search()) {
				list.addAll(searchMapper.getSearch("company_name", vo.getKeyword()));
			}
			if (vo.getDrug_name_search()) {
				list.addAll(searchMapper.getSearch("drug_name_kr", vo.getKeyword()));
			}
			if (vo.getProduct_code_search()) {
				list.addAll(searchMapper.getSearch("product_code", vo.getKeyword()));
			}

			return list;
		}

	}

}
