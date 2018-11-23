package com.qht.model;

import java.io.Serializable;
import java.util.Date;

public class InsertBuyrecordParam implements Serializable {
	public String uid;
	public String tenant_id ;
	public String student_id;
	public String payment_method_id;
	public String course_pkg_id;
	public Date time;
	public String pay_status;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getTenant_id() {
		return tenant_id;
	}
	public void setTenant_id(String tenant_id) {
		this.tenant_id = tenant_id;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getPayment_method_id() {
		return payment_method_id;
	}
	public void setPayment_method_id(String payment_method_id) {
		this.payment_method_id = payment_method_id;
	}
	public String getCourse_pkg_id() {
		return course_pkg_id;
	}
	public void setCourse_pkg_id(String course_pkg_id) {
		this.course_pkg_id = course_pkg_id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getPay_status() {
		return pay_status;
	}
	public void setPay_status(String pay_status) {
		this.pay_status = pay_status;
	}
	@Override
	public String toString() {
		return "InsertBuyrecordModel [uid=" + uid + ", tenant_id=" + tenant_id + ", student_id=" + student_id
				+ ", payment_method_id=" + payment_method_id + ", course_pkg_id=" + course_pkg_id + ", time=" + time
				+ ", pay_status=" + pay_status + "]";
	}
	

}
