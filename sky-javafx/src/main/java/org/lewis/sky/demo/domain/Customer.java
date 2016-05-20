package org.lewis.sky.demo.domain;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	private Date regDate;
	private String phone;
	private String remark;

	public Customer() {
		super();
	}

	public Customer(long id, String name, Date regDate, String phone, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.regDate = regDate;
		this.phone = phone;
		this.remark = remark;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return String.format("Customer [id=%s, name=%s, regDate=%s, phone=%s, remark=%s]", id, name, regDate, phone,
				remark);
	}

}
