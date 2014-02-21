package com.bju.cps450.declarations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.bju.cps450.types.Type;

public class MethodDeclaration extends DeclarationsWithVariables {

	private ClassDeclaration parent;
	private HashMap<String, ParameterDeclaration> parameters = new HashMap<String, ParameterDeclaration>();
	
	public MethodDeclaration() {
		super();
		this.parent = null;
	}
	
	public MethodDeclaration(String name, Type t) {
		super(name, t);
		this.parent = null;
	}
	
	public void addParameter(ParameterDeclaration param) {
		param.setOrder(parameters.size());
		parameters.put(param.getName(), param);
	}
	
	public List<ParameterDeclaration> getParamters() {
		List<ParameterDeclaration> parametersList = new ArrayList<ParameterDeclaration>(parameters.size());
		Iterator<Entry<String, ParameterDeclaration>> it = parameters.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, ParameterDeclaration> pair = (Map.Entry<String, ParameterDeclaration>)it.next();
			parametersList.add(pair.getValue().getOrder(), pair.getValue());
		}
		return parametersList;
	}
	
	@Override
	protected VariableDeclaration lookupInParent(String name) {
		if(parameters.get(name) == null) {
			try {
				return parent.lookupVariable(name);
			} catch(Exception e) { ; }
		} else {
			ParameterDeclaration parameter = parameters.get(name);
			return new VariableDeclaration(parameter.getName(), parameter.getType());
		}
		return null;
	}
	
}
