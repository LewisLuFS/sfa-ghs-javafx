package org.lewis.sky.security.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_SYS_USER")
public class SysUser implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "SN")
	private String sn;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "NAME")
	private String name;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PHONE")
	private String phone;

	public SysUser() {
		super();
	}

	public SysUser(String sn, String password, String name, String email, String phone) {
		super();
		this.sn = sn;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return String.format("SysUser [id=%s, sn=%s, password=%s, name=%s, email=%s, phone=%s]", id, sn, password, name,
				email, phone);
	}

	// private final SimpleStringProperty nick;
	// private final SimpleStringProperty name;
	// private final SimpleStringProperty email;
	// private final SimpleStringProperty phone;
	//
	// public Contact(String nick, String name, String email, String phone) {
	// this.nick = new SimpleStringProperty(nick);
	// this.name = new SimpleStringProperty(name);
	// this.email = new SimpleStringProperty(email);
	// this.phone = new SimpleStringProperty(phone);
	// }
	//
	// public String getNick() {
	// return nick.get();
	// }
	//
	// public void setNick(String nick) {
	// this.nick.set(nick);
	// }
	//
	// public String getName() {
	// return name.get();
	// }
	//
	// public void setName(String name) {
	// this.name.set(name);
	// }
	//
	// public String getEmail() {
	// return email.get();
	// }
	//
	// public void setEmail(String email) {
	// this.email.set(email);
	// }
	//
	// public String getPhone() {
	// return phone.get();
	// }
	//
	// public void setPhone(String phone) {
	// this.phone.set(phone);
	// }
	//
	// @Override
	// public String toString() {
	// return String.format("Contact [nick=%s, name=%s, email=%s, phone=%s]",
	// nick, name, email, phone);
	// }

}
