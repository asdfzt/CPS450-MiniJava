package com.bju.cps450.symbol_table;

import java.util.HashMap;
import java.util.Stack;

import com.bju.cps450.declarations.ClassDeclaration;
import com.bju.cps450.declarations.Declaration;
import com.bju.cps450.declarations.MethodDeclaration;
import com.bju.cps450.declarations.VariableDeclaration;

public class SymbolTable {
	private class Symbol {
		private String name;
		private Declaration decl;
		
		public Symbol(String name, Declaration decl) {
			this.name = name;
			this.decl = decl;
		}
		
		public String getName() {
			return this.name;
		}
		
		public Declaration getDeclaration() {
			return this.decl;
		}
	}
	
	private Stack<HashMap<String, Symbol>> symbolTable = new Stack<HashMap<String, Symbol>>();
	private Declaration lastPushedDeclaration;
	private ClassDeclaration lastPushedClass;
	private MethodDeclaration lastPushedMethod;
	private VariableDeclaration lastPushedVariable;
	
	public Symbol push(String name, Declaration decl) {
		return null;
	}
	
	public Symbol lookup(String name) {
		return null;
	}
	
	public void beginScope() {
		
	}
	
	public void endScope() {
		
	}
	
	public int getScope() {
		return 0;
	}
	
	public Declaration getLastPushed() {
		return this.lastPushedDeclaration;
	}
	
	public Declaration getLastPushedClass() {
		return this.lastPushedClass;
	}
	
	public Declaration getLastPushedMethod() {
		return this.lastPushedMethod;
	}
	
	public Declaration getLastPushedVariable() {
		return this.lastPushedVariable;
	}
}
