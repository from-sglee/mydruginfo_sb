package com.mydruginfo.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor @RequiredArgsConstructor @Getter @Setter
public class StandardCode {
	@NonNull String drug_name_kr;			// not null
	@NonNull String company_name;			// not null
	String pharma_standard;
	int quantity;
	String formulation_type;
	String package_type;
	@NonNull int item_code;				// not null
	String date_authorization;
	String drug_type;
	@NonNull Long representative_code;		// not null
	@NonNull Long standard_code;
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
	//String reg_date;				// not null (default current_timestamp)

	public StandardCode() {
		super();
		// TODO Auto-generated constructor stub
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
				+ specialcare_type + ", reading_equipment=" + reading_equipment + "]";
	}
}
