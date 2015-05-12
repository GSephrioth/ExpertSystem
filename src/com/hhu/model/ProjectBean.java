package com.hhu.model;

/**
 * 科研项目Bean,和数据库保持一致
 * @author sunzequn
 *
 */
public class ProjectBean {

	String pj_id;
	String pj_name;
	String pj_info;
	String pj_request;
	String te_id;
	String pj_close_time;
	String pj_is_closed;
	String pj_depart;
	
	public String getPj_id() {
		return pj_id;
	}
	public void setPj_id(String pj_id) {
		this.pj_id = pj_id;
	}
	public String getPj_name() {
		return pj_name;
	}
	public void setPj_name(String pj_name) {
		this.pj_name = pj_name;
	}
	public String getPj_info() {
		return pj_info;
	}
	public void setPj_info(String pj_info) {
		this.pj_info = pj_info;
	}
	public String getPj_request() {
		return pj_request;
	}
	public void setPj_request(String pj_request) {
		this.pj_request = pj_request;
	}
	
	public String getTe_id() {
		return te_id;
	}
	public void setTe_id(String te_id) {
		this.te_id = te_id;
	}
	public String getPj_close_time() {
		return pj_close_time;
	}
	public void setPj_close_time(String pj_close_time) {
		this.pj_close_time = pj_close_time;
	}
	public String getPj_is_closed() {
		return pj_is_closed;
	}
	public void setPj_is_closed(String pj_is_closed) {
		this.pj_is_closed = pj_is_closed;
	}
	public String getPj_depart() {
		return pj_depart;
	}
	public void setPj_depart(String pj_depart) {
		this.pj_depart = pj_depart;
	}
	
}
