package com.managerplat.model;

import java.io.Serializable;
import java.util.List;

public class Sellers implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sellerId;
	private String sellerName;
	private String sellerPassword;
	private double sellerStar;
	private String sellerImagePath;
	private String sellerIDCardPath;
	private String sellerLicencePath;
	
	
	public String getSellerPassword() {
		return sellerPassword;
	}
	public void setSellerPassword(String sellerPassword) {
		this.sellerPassword = sellerPassword;
	}
	public String getSellerLicencePath() {
		return sellerLicencePath;
	}
	public void setSellerLicencePath(String sellerLicencePath) {
		this.sellerLicencePath = sellerLicencePath;
	}
	private int sellerPhone;
	private int isRegist;
	
	
	public int getIsRegist() {
		return isRegist;
	}
	public void setIsRegist(int isRegist) {
		this.isRegist = isRegist;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public double getSellerStar() {
		return sellerStar;
	}
	public void setSellerStar(double sellerStar) {
		this.sellerStar = sellerStar;
	}
	public String getSellerImagePath() {
		return sellerImagePath;
	}
	public void setSellerImagePath(String sellerImagePath) {
		this.sellerImagePath = sellerImagePath;
	}
	public String getSellerIDCardPath() {
		return sellerIDCardPath;
	}
	public void setSellerIDCardPath(String sellerIDCardPath) {
		this.sellerIDCardPath = sellerIDCardPath;
	}
	public int getSellerPhone() {
		return sellerPhone;
	}
	public void setSellerPhone(int sellerPhone) {
		this.sellerPhone = sellerPhone;
	}

	
	
}
