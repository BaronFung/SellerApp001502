package com.managerplat.model;

import java.io.Serializable;
import java.util.List;

public class SellerInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private byte[] SellerImage;

	private int sellerId;
	
	private String sellerName;

	private double sellerStar;
	
	private int sellerPhone;

	private List<DishInfo> sellerDishes;
	
	
	public int getSellerPhone() {
		return sellerPhone;
	}

	public void setSellerPhone(int sellerPhone) {
		this.sellerPhone = sellerPhone;
	}

	

	public byte[] getSellerImage() {
		return SellerImage;
	}

	public void setSellerImage(byte[] sellerImage) {
		SellerImage = sellerImage;
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

	public List<DishInfo> getSellerDishes() {
		return sellerDishes;
	}

	public void setSellerDishes(List<DishInfo> sellerDishes) {
		this.sellerDishes = sellerDishes;
	}
}
