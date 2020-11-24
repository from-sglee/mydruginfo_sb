package com.mydruginfo.model;


public class SearchVO {
	private boolean all_search;
	private boolean drug_name_search;
	private boolean company_name_search;
	private boolean ATC_code_search;
	private boolean product_code_search;
	private boolean common_name_code_search;
	
	private String keyword;
	
	

	
	public boolean getAll_search() {
		return all_search;
	}

	public void setAll_search(boolean all_search) {
		this.all_search = all_search;
	}

	public boolean getDrug_name_search() {
		return drug_name_search;
	}

	public void setDrug_name_search(boolean drug_name_search) {
		this.drug_name_search = drug_name_search;
	}

	public boolean getCompany_name_search() {
		return company_name_search;
	}

	public void setCompany_name_search(boolean company_name_search) {
		this.company_name_search = company_name_search;
	}

	public boolean getATC_code_search() {
		return ATC_code_search;
	}

	public void setATC_code_search(boolean aTC_code_search) {
		ATC_code_search = aTC_code_search;
	}

	public boolean getProduct_code_search() {
		return product_code_search;
	}

	public void setProduct_code_search(boolean product_code_search) {
		this.product_code_search = product_code_search;
	}

	public boolean getCommon_name_code_search() {
		return common_name_code_search;
	}

	public void setCommon_name_code_search(boolean common_name_code_search) {
		this.common_name_code_search = common_name_code_search;
	}

	public String getKeyword() {
		return keyword;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
