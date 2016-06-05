package com.managerplat.model;
import java.io.Serializable;


public class UserInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int userId;
	private String userName;
	private String userPassword;
	private String userAddress;
	private String userPhone;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public UserInfo(String userName, String userPassword, String userPhone) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
	}

	public UserInfo() {
		// TODO Auto-generated constructor stub
	}
	
}
