package com.hhu.model;

/**
 * 学生Bean,和数据库保持一致
 * @author sunzequn
 *
 */
public class StudentBean {

	String st_id;
	String st_name;
	String st_depart;
	String st_info;
	String st_email;

	public String getSt_id() {
		return st_id;
	}
	public void setSt_id(String st_id) {
		this.st_id = st_id;
	}
	public String getSt_name() {
		return st_name;
	}
	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}
	public String getSt_depart() {
		return st_depart;
	}
	public void setSt_depart(String st_depart) {
		this.st_depart = st_depart;
	}
	public String getSt_info() {
		return st_info;
	}
	public void setSt_info(String st_info) {
		this.st_info = st_info;
	}
	public String getSt_email() {
		return st_email;
	}
	public void setSt_email(String st_email) {
		this.st_email = st_email;
	}
}
