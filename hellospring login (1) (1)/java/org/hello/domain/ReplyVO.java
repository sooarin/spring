package org.hello.domain;
import java.util.Date;

public class ReplyVO {
	private int b_no;
	private int r_no;
	private String b_detail;
	private String b_writer;
	private Date b_date;
	
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public int getR_no() {
		return r_no;
	}
	public void setR_no(int r_no) {
		this.r_no = r_no;
	}
	public String getB_detail() {
		return b_detail;
	}
	public void setB_detail(String b_detail) {
		this.b_detail = b_detail;
	}
	public String getB_writer() {
		return b_writer;
	}
	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}
	public Date getB_date() {
		return b_date;
	}
	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}
}
