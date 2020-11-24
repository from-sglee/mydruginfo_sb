package com.mydruginfo.model;

import lombok.NonNull;

public class AdminVO {
	
	
	
	@NonNull int seq;
	@NonNull String admin_id;
	@NonNull String admin_pw;
	@NonNull String admin_name;
	@NonNull String admin_email;
	@NonNull String admin_type;
	char del_yn;
	
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_pw() {
		return admin_pw;
	}
	public void setAdmin_pw(String admin_pw) {
		this.admin_pw = admin_pw;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_email() {
		return admin_email;
	}
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}
	public String getAdmin_type() {
		return admin_type;
	}
	public void setAdmin_type(String admin_type) {
		this.admin_type = admin_type;
	}
	public char getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(char del_yn) {
		this.del_yn = del_yn;
	}
	
	@Override
	public String toString() {
		return "AdminVO [seq=" + seq + ", admin_id=" + admin_id + ", admin_pw=" + admin_pw + ", admin_name="
				+ admin_name + ", admin_email=" + admin_email + ", admin_type=" + admin_type + ", del_yn=" + del_yn
				+ "]";
	}
	
	
	

}
