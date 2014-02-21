package com.bju.cps450.declarations;

import com.bju.cps450.types.Type;

public class VariableDeclaration extends Declaration {
	public VariableDeclaration() {
		super();
	}
	
	public VariableDeclaration(String name, Type t) {
		super(name, t);
	}
}
