package com.bju.cps450.types;

public class Type implements Comparable<Type> {
	public static final Type error = new Type("ERROR"),
			                 integer = new Type("INT"),
			                 bool = new Type("BOOL"),
			                 string = new Type("STRING");
			
	private String name;		
	
	public Type(String name) {
		this.name = name.toUpperCase();
	}
	
	public String getName() {
		return this.name;
	}

	@Override
	public int compareTo(Type arg0) {
		return name.compareTo(arg0.getName());
	}
}
