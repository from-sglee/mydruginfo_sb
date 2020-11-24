package com.mydruginfo.model;

public class StandardCode {
	String drug_name_kr;			// not null
	String company_name;			// not null
	String pharma_standard;
	int quantity;
	String formulation_type;
	String package_type;
	int item_code;				// not null
	String date_authorization;
	String drug_type;
	Long representative_code;		// not null
	Long standard_code;
	int product_code;
	String common_name_code;
	String memo;
	String cancellation_date;
	String effective_date;
	String end_date;
	String serialnumber_yn;
	String memo_serialnumber;
	String atc_code;
	String specialcare_type;
	String reading_equipment;
	String image_url;
	String reg_date;				// not null (default current_timestamp)

	public StandardCode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StandardCode(String drug_name_kr, String company_name, String pharma_standard, int quantity,
			String formulation_type, String package_type, int item_code, String date_authorization, String drug_type,
			Long representative_code, Long standard_code, int product_code, String common_name_code, String memo,
			String cancellation_date, String effective_date, String end_date, String serialnumber_yn,
			String memo_serialnumber, String atc_code, String specialcare_type, String reading_equipment,
			String image_url, String reg_date) {
		super();
		this.drug_name_kr = drug_name_kr;
		this.company_name = company_name;
		this.pharma_standard = pharma_standard;
		this.quantity = quantity;
		this.formulation_type = formulation_type;
		this.package_type = package_type;
		this.item_code = item_code;
		this.date_authorization = date_authorization;
		this.drug_type = drug_type;
		this.representative_code = representative_code;
		this.standard_code = standard_code;
		this.product_code = product_code;
		this.common_name_code = common_name_code;
		this.memo = memo;
		this.cancellation_date = cancellation_date;
		this.effective_date = effective_date;
		this.end_date = end_date;
		this.serialnumber_yn = serialnumber_yn;
		this.memo_serialnumber = memo_serialnumber;
		this.atc_code = atc_code;
		this.specialcare_type = specialcare_type;
		this.reading_equipment = reading_equipment;
		this.image_url = image_url;
		this.reg_date = reg_date;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getFormulation_type() {
		return formulation_type;
	}

	public void setFormulation_type(String formulation_type) {
		this.formulation_type = formulation_type;
	}

	public String getPackage_type() {
		return package_type;
	}

	public void setPackage_type(String package_type) {
		this.package_type = package_type;
	}

	public int getItem_code() {
		return item_code;
	}

	public void setItem_code(int item_code) {
		this.item_code = item_code;
	}

	public String getDate_authorization() {
		return date_authorization;
	}

	public void setDate_authorization(String date_authorization) {
		this.date_authorization = date_authorization;
	}

	public String getDrug_type() {
		return drug_type;
	}

	public void setDrug_type(String drug_type) {
		this.drug_type = drug_type;
	}

	public Long getRepresentative_code() {
		return representative_code;
	}

	public void setRepresentative_code(Long representative_code) {
		this.representative_code = representative_code;
	}

	public Long getStandard_code() {
		return standard_code;
	}

	public void setStandard_code(Long standard_code) {
		this.standard_code = standard_code;
	}

	public int getProduct_code() {
		return product_code;
	}

	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}

	public String getCommon_name_code() {
		return common_name_code;
	}

	public void setCommon_name_code(String common_name_code) {
		this.common_name_code = common_name_code;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getCancellation_date() {
		return cancellation_date;
	}

	public void setCancellation_date(String cancellation_date) {
		this.cancellation_date = cancellation_date;
	}

	public String getEffective_date() {
		return effective_date;
	}

	public void setEffective_date(String effective_date) {
		this.effective_date = effective_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getSerialnumber_yn() {
		return serialnumber_yn;
	}

	public void setSerialnumber_yn(String serialnumber_yn) {
		this.serialnumber_yn = serialnumber_yn;
	}

	public String getMemo_serialnumber() {
		return memo_serialnumber;
	}

	public void setMemo_serialnumber(String memo_serialnumber) {
		this.memo_serialnumber = memo_serialnumber;
	}

	public String getAtc_code() {
		return atc_code;
	}

	public void setAtc_code(String atc_code) {
		this.atc_code = atc_code;
	}

	public String getSpecialcare_type() {
		return specialcare_type;
	}

	public void setSpecialcare_type(String specialcare_type) {
		this.specialcare_type = specialcare_type;
	}

	public String getReading_equipment() {
		return reading_equipment;
	}

	public void setReading_equipment(String reading_equipment) {
		this.reading_equipment = reading_equipment;
	}
	
	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	
	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "StandardCode [drug_name_kr=" + drug_name_kr + ", company_name=" + company_name + ", pharma_standard="
				+ pharma_standard + ", quantity=" + quantity + ", formulation_type=" + formulation_type
				+ ", package_type=" + package_type + ", item_code=" + item_code + ", date_authorization="
				+ date_authorization + ", drug_type=" + drug_type + ", representative_code=" + representative_code
				+ ", standard_code=" + standard_code + ", product_code=" + product_code + ", common_name_code="
				+ common_name_code + ", memo=" + memo + ", cancellation_date=" + cancellation_date + ", effective_date="
				+ effective_date + ", end_date=" + end_date + ", serialnumber_yn=" + serialnumber_yn
				+ ", memo_serialnumber=" + memo_serialnumber + ", atc_code=" + atc_code + ", specialcare_type="
				+ specialcare_type + ", reading_equipment=" + reading_equipment + ", image_url=" + image_url + ", reg_date=" + reg_date + "]";
	}
}
