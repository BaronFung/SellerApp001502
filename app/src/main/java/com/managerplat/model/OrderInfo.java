package com.managerplat.model;

import java.io.Serializable;
import java.util.List;


public class OrderInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int orderId;
	
	private int userId;
	private int sellerId;
	
	private int dishId;
	private int count;
	private String userAddr;
	private String date;
	private int isSuc;
	
	public int getIsSuc() {
		return isSuc;
	}
	public void setIsSuc(int isSuc) {
		this.isSuc = isSuc;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public int getDishId() {
		return dishId;
	}
	public void setDishId(int dishId) {
		this.dishId = dishId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public OrderInfo(int userId, int sellerId, int dishId, int count, String userAddr) {
		this.userId = userId;
		this.sellerId = sellerId;
		this.dishId = dishId;
		this.count = count;
		this.userAddr = userAddr;
	}
	public OrderInfo() {
		super();
	}
	
}
