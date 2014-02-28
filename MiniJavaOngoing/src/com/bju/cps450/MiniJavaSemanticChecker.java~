package com.bju.cps450;

import java.util.HashMap;

import com.bju.cps450.analysis.DepthFirstAdapter;
import com.bju.cps450.node.Node;
import com.bju.cps450.symbol_table.SymbolTable;

public class MiniJavaSemanticChecker extends DepthFirstAdapter {
	private SymbolTable symbolTable = new SymbolTable();
	private HashMap<Node, HashMap<String, Object>> attributeGrammarMap = new HashMap<Node, HashMap<String, Object>>();
	
	private void initNode(Node node) {
		if(attributeGrammarMap.get(node) == null) {
			attributeGrammarMap.put(node, new HashMap<String, Object>());
		}
	}
}
