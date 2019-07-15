package com.seho.rule.engine.bean;

public class Order {
	
	private Product product;
	
	private String status;	
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public enum Status {
		PROCESSED, NON_PROCESSED
	}

}
