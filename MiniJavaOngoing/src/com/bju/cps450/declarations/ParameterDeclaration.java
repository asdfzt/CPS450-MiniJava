package com.bju.cps450.declarations;

import com.bju.cps450.types.Type;

public class ParameterDeclaration extends Declaration {
	private int order;
	
	public ParameterDeclaration() {
		super();
	}
	
	public ParameterDeclaration(String name, Type t) {
		super(name, t);
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
	
	public int getOrder() {
		return this.order;
	}
}
