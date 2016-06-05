package com.managerplat.model;

import java.io.Serializable;


public class DishInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private int dishId;
	
	private int sellerId;

	private String dishName;

	private double dishPrice;

	private byte[] dishImage;
	
	private String dishImagePath;
	

	public String getDishImagePath() {
		return dishImagePath;
	}


	public void setDishImagePath(String dishImagePath) {
		this.dishImagePath = dishImagePath;
	}


	public int getSellerId() {
		return sellerId;
	}


	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}


	public byte[] getDishImage() {
		return dishImage;
	}

	
	public void setDishImage(byte[] dishImage) {
		this.dishImage = dishImage;
	}

	public int getDishId() {
		return dishId;
	}

	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public double getDishPrice() {
		return dishPrice;
	}

	public void setDishPrice(double dishPrice) {
		this.dishPrice = dishPrice;
	}
	
}
