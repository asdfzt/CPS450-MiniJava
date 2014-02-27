package com.bju.cps450.declarations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.bju.cps450.types.Type;

public class ClassDeclaration extends DeclarationsWithVariables {

	private ClassDeclaration inheritsFrom;
	private HashMap<String, MethodDeclaration> methods = new HashMap<String, MethodDeclaration>();
	
	public ClassDeclaration() {
		super();
		this.inheritsFrom = null;
	}
	
	public ClassDeclaration(String name, Type t) {
		super(name, t);
		this.inheritsFrom = null;
	}
	
	public void addMethod(MethodDeclaration param) {
		methods.put(param.getName(), param);
	}
	
	public List<MethodDeclaration> getMethods() {
		List<MethodDeclaration> methodsList = new ArrayList<MethodDeclaration>();
		Iterator<Entry<String, MethodDeclaration>> it = methods.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, MethodDeclaration> pair = (Map.Entry<String, MethodDeclaration>)it.next();
			methodsList.add(pair.getValue());
		}
		return methodsList;
	}
	
	protected MethodDeclaration lookupMethod(String name) throws Exception {
		if(methods.get(name) == null) {
			if(inheritsFrom != null) {
				try {
					return inheritsFrom.lookupMethod(name);
				} catch (Exception e) { ; }
			}
			throw new Exception("no method with name " + name + " was found");
		} else {
			return methods.get(name);
		}
	}
	
	@Override
	protected VariableDeclaration lookupInParent(String name) {
		if(inheritsFrom != null) {
			try {
				return inheritsFrom.lookupVariable(name);
			} catch (Exception e) { ; }
		}
		return null;
	}
	
	public void setParent(ClassDeclaration decl) {
		this.inheritsFrom = decl;
	}
	
	public ClassDeclaration getParent() {
		return this.inheritsFrom;
	}
}
