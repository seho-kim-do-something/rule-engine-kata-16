package com.seho.rule.engine.bean;

public class Category {

	private String categoryName;
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public enum CategoryName {
		BOOK, VIDEO, LAPTOP, MEMBERSHIP, MEMBERSHIP_UPGRADE
	}

}
