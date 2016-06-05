package com.managerplat.model;

import java.io.Serializable;
import java.util.List;

public class Orders implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<OrderInfo> list;

	public List<OrderInfo> getList() {
		return list;
	}

	public void setList(List<OrderInfo> list) {
		this.list = list;
	}
	
}
