package com.seho.rule.engine.bean;

public class Type {
	
	private String typeName;
	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public enum TypeName {
        PHYSICAL, NON_PHYSICAL
    }
	
}
