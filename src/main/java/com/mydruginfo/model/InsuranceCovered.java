package com.mydruginfo.model;

public class InsuranceCovered {
	
	String administaraion_method;
	int classification_code;
	String main_ingredient_code;
	String main_ingredient_code_name;
	String product_code;
	String drug_name_kr;
	String company_name;
	String pharma_standard;
	String formulation_type;
	String price_limit;
	String drug_type;
	String memo;
	int product_code_before;
	String reg_date;
	public InsuranceCovered() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAdministaraion_method() {
		return administaraion_method;
	}
	public void setAdministaraion_method(String administaraion_method) {
		this.administaraion_method = administaraion_method;
	}
	public int getClassification_code() {
		return classification_code;
	}
	public void setClassification_code(int classification_code) {
		this.classification_code = classification_code;
	}
	public String getMain_ingredient_code() {
		return main_ingredient_code;
	}
	public void setMain_ingredient_code(String main_ingredient_code) {
		this.main_ingredient_code = main_ingredient_code;
	}
	public String getMain_ingredient_code_name() {
		return main_ingredient_code_name;
	}
	public void setMain_ingredient_code_name(String main_ingredient_code_name) {
		this.main_ingredient_code_name = main_ingredient_code_name;
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public String getDrug_name_kr() {
		return drug_name_kr;
	}
	public void setDrug_name_kr(String drug_name_kr) {
		this.drug_name_kr = drug_name_kr;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getPharma_standard() {
		return pharma_standard;
	}
	public void setPharma_standard(String pharma_standard) {
		this.pharma_standard = pharma_standard;
	}
	public String getFormulation_type() {
		return formulation_type;
	}
	public void setFormulation_type(String formulation_type) {
		this.formulation_type = formulation_type;
	}
	public String getPrice_limit() {
		return price_limit;
	}
	public void setPrice_limit(String price_limit) {
		this.price_limit = price_limit;
	}
	public String getDrug_type() {
		return drug_type;
	}
	public void setDrug_type(String drug_type) {
		this.drug_type = drug_type;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getProduct_code_before() {
		return product_code_before;
	}
	public void setProduct_code_before(int product_code_before) {
		this.product_code_before = product_code_before;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "InsuranceCovered [administaraion_method=" + administaraion_method + ", classification_code="
				+ classification_code + ", main_ingredient_code=" + main_ingredient_code
				+ ", main_ingredient_code_name=" + main_ingredient_code_name + ", product_code=" + product_code
				+ ", drug_name_kr=" + drug_name_kr + ", company_name=" + company_name + ", pharma_standard="
				+ pharma_standard + ", formulation_type=" + formulation_type + ", price_limit=" + price_limit
				+ ", drug_type=" + drug_type + ", memo=" + memo + ", product_code_before=" + product_code_before
				+ ", reg_date=" + reg_date + "]";
	}
	

}
