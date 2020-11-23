package com.mydruginfo.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor @RequiredArgsConstructor @AllArgsConstructor @Getter @Setter @ToString
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
	String reg_date;				// not null (default current_timestamp)

}
