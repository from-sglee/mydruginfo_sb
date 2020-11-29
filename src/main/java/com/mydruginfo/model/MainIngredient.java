package com.mydruginfo.model;

public class MainIngredient {
	
	String main_ingredient_code;
	String formulation_type_code;
	String main_ingredient_name;
	int classification_code;
	String administration_method;
	String content_amount;
	String unit;
	String reg_date;
	

	public MainIngredient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMain_ingredient_code() {
		return main_ingredient_code;
	}
	public void setMain_ingredient_code(String main_ingredient_code) {
		this.main_ingredient_code = main_ingredient_code;
	}
	public String getFormulation_type_code() {
		return formulation_type_code;
	}
	public void setFormulation_type_code(String formulation_type_code) {
		this.formulation_type_code = formulation_type_code;
	}
	public String getMain_ingredient_name() {
		return main_ingredient_name;
	}
	public void setMain_ingredient_name(String main_ingredient_name) {
		this.main_ingredient_name = main_ingredient_name;
	}
	public int getClassification_code() {
		return classification_code;
	}
	public void setClassification_code(int classification_code) {
		this.classification_code = classification_code;
	}
	public String getAdministration_method() {
		return administration_method;
	}
	public void setAdministration_method(String administration_method) {
		this.administration_method = administration_method;
	}
	public String getContent_amount() {
		return content_amount;
	}
	public void setContent_amount(String content_amount) {
		this.content_amount = content_amount;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "MainIngredient [main_ingredient_code=" + main_ingredient_code + ", formulation_type_code="
				+ formulation_type_code + ", main_ingredient_name=" + main_ingredient_name + ", classification_code="
				+ classification_code + ", administration_method=" + administration_method + ", content_amount="
				+ content_amount + ", unit=" + unit + ", reg_date=" + reg_date + "]";
	}
	

}
