package com.bju.cps450.declarations;

import com.bju.cps450.types.Type;

public class Declaration {
	protected String declName;
	protected Type declType;
	
	public Declaration() {
		this.declName = "";
		this.declType = null;
	}
	
	public Declaration(String name, Type t) {
		this.declName = name;
		this.declType = t;
	}
	
	public void setName(String name) {
		this.declName = name;
	}
	
	public void setType(Type t) {
		this.declType = t;
	}
	
	public String getName() {
		return this.declName;
	}
	
	public Type getType() {
		return this.declType;
	}
}
