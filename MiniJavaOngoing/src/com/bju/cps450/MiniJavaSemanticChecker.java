package com.bju.cps450;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.bju.cps450.analysis.DepthFirstAdapter;
import com.bju.cps450.declarations.ClassDeclaration;
import com.bju.cps450.declarations.Declaration;
import com.bju.cps450.declarations.MethodDeclaration;
import com.bju.cps450.declarations.ParameterDeclaration;
import com.bju.cps450.declarations.VariableDeclaration;
import com.bju.cps450.node.AAdditionExpression;
import com.bju.cps450.node.AAndExpression;
import com.bju.cps450.node.AArgument;
import com.bju.cps450.node.AArrayAssignmentStatement;
import com.bju.cps450.node.AAssignmentStatement;
import com.bju.cps450.node.ABooleanType;
import com.bju.cps450.node.AClassDefinition;
import com.bju.cps450.node.ADivisionExpression;
import com.bju.cps450.node.AEqualsExpression;
import com.bju.cps450.node.AFalseExpression;
import com.bju.cps450.node.AGreaterThanExpression;
import com.bju.cps450.node.AIdentifierExpression;
import com.bju.cps450.node.AIfStatement;
import com.bju.cps450.node.AIntArrayType;
import com.bju.cps450.node.AIntExpression;
import com.bju.cps450.node.AIntType;
import com.bju.cps450.node.ALessThanExpression;
import com.bju.cps450.node.AMethod;
import com.bju.cps450.node.AMethodCallExpression;
import com.bju.cps450.node.AMultiplicationExpression;
import com.bju.cps450.node.ANegationExpression;
import com.bju.cps450.node.AOrExpression;
import com.bju.cps450.node.AReturnStatement;
import com.bju.cps450.node.AStringArrayType;
import com.bju.cps450.node.AStringExpression;
import com.bju.cps450.node.AStringType;
import com.bju.cps450.node.ASubtractionExpression;
import com.bju.cps450.node.AThisExpression;
import com.bju.cps450.node.ATrueExpression;
import com.bju.cps450.node.AVariable;
import com.bju.cps450.node.AVoidType;
import com.bju.cps450.node.AWhileStatement;
import com.bju.cps450.node.Node;
import com.bju.cps450.node.PArgument;
import com.bju.cps450.node.PStatement;
import com.bju.cps450.node.PVariable;
import com.bju.cps450.symbol_table.SymbolTable;
import com.bju.cps450.types.Type;

public class MiniJavaSemanticChecker extends DepthFirstAdapter {
	private SymbolTable symbolTable = new SymbolTable();
	private HashMap<Node, HashMap<String, Object>> attributeGrammarMap = new HashMap<Node, HashMap<String, Object>>();
	
	private void initNode(Node node) {
		if(attributeGrammarMap.get(node) == null) {
			attributeGrammarMap.put(node, new HashMap<String, Object>());
		}
	}

	@Override
	public void inAClassDefinition(AClassDefinition node) {
		super.inAClassDefinition(node);
		try {
			//make sure class does not yet exist
			String name = node.getIdentifier().getText();
			try {
				Declaration decl = symbolTable.lookup(name).getDeclaration();
				if(decl instanceof ClassDeclaration) {
					//print a error
					return;
				}
			} catch(Exception e) {
				
			}
			
			//create a ClassDeclaration
			ClassDeclaration decl = new ClassDeclaration(name, new Type(name));
			symbolTable.push(name, decl);
			
			//start a scope for the new class
			symbolTable.beginScope();
		} catch (Exception e) {
			// print a helpful here
		}
	}

	@Override
	public void outAClassDefinition(AClassDefinition node) {
		super.outAClassDefinition(node);
		try {
			symbolTable.endScope();
		} catch (Exception e) {
			// print a helpful here
		}
	}

	@Override
	public void outAVariable(AVariable node) {
		super.outAVariable(node);
		//make sure method does not yet exist
		String name = node.getIdentifier().getText();
		try {
			Declaration decl = symbolTable.lookup(name).getDeclaration();
			if(decl instanceof VariableDeclaration) {
				//print a error
				return;
			}
		} catch(Exception e) {
			
		}
		
		//create a MethodDeclaration
		Type t = (Type)attributeGrammarMap.get(node.getType()).get("type");
		VariableDeclaration decl = new VariableDeclaration(name, t);
		symbolTable.push(name, decl);
	}

	@Override
	public void inAMethod(AMethod node) {
		super.inAMethod(node);
		try {
			//make sure method does not yet exist
			String name = node.getIdentifier().getText();
			try {
				Declaration decl = symbolTable.lookup(name).getDeclaration();
				if(decl instanceof MethodDeclaration) {
					//print a error
					return;
				}
			} catch(Exception e) {
				
			}
			
			//create a MethodDeclaration
			MethodDeclaration decl = new MethodDeclaration();
			decl.setName(name);
			symbolTable.push(name, decl);
			
			//start a scope for the new class
			symbolTable.beginScope();
		} catch (Exception e) {
			// print a helpful here
		}
	}

	@Override
	public void caseAMethod(AMethod node) {
		inAMethod(node);
        if(node.getType() != null)
        {
            node.getType().apply(this);
            //pull off type and add to method
            Type t = (Type)attributeGrammarMap.get(node.getType()).get("type");
            symbolTable.getLastPushedMethod().setType(t);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        {
            List<PArgument> copy = new ArrayList<PArgument>(node.getArgument());
            for(PArgument e : copy)
            {
                e.apply(this);
            }
        }
        {
            List<PVariable> copy = new ArrayList<PVariable>(node.getVariable());
            for(PVariable e : copy)
            {
                e.apply(this);
            }
        }
        {
            List<PStatement> copy = new ArrayList<PStatement>(node.getStatement());
            for(PStatement e : copy)
            {
                e.apply(this);
            }
        }
        outAMethod(node);
	}

	@Override
	public void outAMethod(AMethod node) {
		super.outAMethod(node);
		try {
			symbolTable.endScope();
		} catch (Exception e) {
			// print a helpful here
		}
	}

	@Override
	public void outAIntArrayType(AIntArrayType node) {
		// TODO Auto-generated method stub
		super.outAIntArrayType(node);
	}

	@Override
	public void outAStringArrayType(AStringArrayType node) {
		// TODO Auto-generated method stub
		super.outAStringArrayType(node);
	}

	@Override
	public void outAIntType(AIntType node) {
		super.outAIntType(node);
		initNode(node);
		attributeGrammarMap.get(node).put("type", Type.integer);
	}

	@Override
	public void outABooleanType(ABooleanType node) {
		// TODO Auto-generated method stub
		super.outABooleanType(node);
	}

	@Override
	public void outAStringType(AStringType node) {
		// TODO Auto-generated method stub
		super.outAStringType(node);
	}

	@Override
	public void outAVoidType(AVoidType node) {
		// TODO Auto-generated method stub
		super.outAVoidType(node);
	}

	@Override
	public void outAArgument(AArgument node) {
		super.outAArgument(node);
		String name = node.getIdentifier().getText();
		Type t = (Type)attributeGrammarMap.get(node.getType()).get("type");
		ParameterDeclaration decl = new ParameterDeclaration(name, t);
		symbolTable.getLastPushedMethod().addParameter(decl);
		
		VariableDeclaration decl2 = new VariableDeclaration(decl.getName(), decl.getType());
		symbolTable.push(name, decl2);
	}

	@Override
	public void outAReturnStatement(AReturnStatement node) {
		// TODO Auto-generated method stub
		super.outAReturnStatement(node);
	}

	@Override
	public void outAOrExpression(AOrExpression node) {
		// TODO Auto-generated method stub
		super.outAOrExpression(node);
	}

	@Override
	public void outAAndExpression(AAndExpression node) {
		// TODO Auto-generated method stub
		super.outAAndExpression(node);
	}

	@Override
	public void outAGreaterThanExpression(AGreaterThanExpression node) {
		// TODO Auto-generated method stub
		super.outAGreaterThanExpression(node);
	}

	@Override
	public void outALessThanExpression(ALessThanExpression node) {
		// TODO Auto-generated method stub
		super.outALessThanExpression(node);
	}

	@Override
	public void outAEqualsExpression(AEqualsExpression node) {
		// TODO Auto-generated method stub
		super.outAEqualsExpression(node);
	}

	@Override
	public void outAAdditionExpression(AAdditionExpression node) {
		// TODO Auto-generated method stub
		super.outAAdditionExpression(node);
	}

	@Override
	public void outASubtractionExpression(ASubtractionExpression node) {
		// TODO Auto-generated method stub
		super.outASubtractionExpression(node);
	}

	@Override
	public void outAMultiplicationExpression(AMultiplicationExpression node) {
		super.outAMultiplicationExpression(node);
		initNode(node);
		
		Type t = Type.error;
		Type lhs = (Type)attributeGrammarMap.get(node.getLhs()).get("type");
		Type rhs = (Type)attributeGrammarMap.get(node.getRhs()).get("type");
		if(lhs.compareTo(rhs) == 0 && (lhs.compareTo(Type.integer) == 0/* || other types here */)) {
			t = Type.integer;
		} else {
			//print an error
		}
		
		attributeGrammarMap.get(node).put("type", t);
	}

	@Override
	public void outAIfStatement(AIfStatement node) {
		super.outAIfStatement(node);
		Type t = (Type)attributeGrammarMap.get(node).get("type");
		//ensure this a boolean
		if(t.compareTo(Type.bool) == 0) {
			
		} else {
			//print error
		}
	}

	@Override
	public void outAWhileStatement(AWhileStatement node) {
		// TODO Auto-generated method stub
		super.outAWhileStatement(node);
	}

	@Override
	public void outAAssignmentStatement(AAssignmentStatement node) {
		// TODO Auto-generated method stub
		super.outAAssignmentStatement(node);
	}

	@Override
	public void outAArrayAssignmentStatement(AArrayAssignmentStatement node) {
		// TODO Auto-generated method stub
		super.outAArrayAssignmentStatement(node);
	}

	@Override
	public void outADivisionExpression(ADivisionExpression node) {
		// TODO Auto-generated method stub
		super.outADivisionExpression(node);
	}

	@Override
	public void outANegationExpression(ANegationExpression node) {
		// TODO Auto-generated method stub
		super.outANegationExpression(node);
	}

	@Override
	public void outAMethodCallExpression(AMethodCallExpression node) {
		// TODO Auto-generated method stub
		super.outAMethodCallExpression(node);
	}

	@Override
	public void outAIntExpression(AIntExpression node) {
		super.outAIntExpression(node);
		initNode(node);
		attributeGrammarMap.get(node).put("type", Type.integer);
	}

	@Override
	public void outAStringExpression(AStringExpression node) {
		// TODO Auto-generated method stub
		super.outAStringExpression(node);
	}

	@Override
	public void outATrueExpression(ATrueExpression node) {
		// TODO Auto-generated method stub
		super.outATrueExpression(node);
	}

	@Override
	public void outAFalseExpression(AFalseExpression node) {
		// TODO Auto-generated method stub
		super.outAFalseExpression(node);
	}

	@Override
	public void outAIdentifierExpression(AIdentifierExpression node) {
		super.outAIdentifierExpression(node);
		initNode(node);
		String name = node.getIdentifier().getText();
		try {
			Declaration d = symbolTable.lookup(name).getDeclaration();
			if(!(d instanceof VariableDeclaration)) {
				//print error
				attributeGrammarMap.get(node).put("type", Type.error);
			} else {
				attributeGrammarMap.get(node).put("type", d.getType());
			}
		} catch (Exception e) {
			//print error
			attributeGrammarMap.get(node).put("type", Type.error);
		}
	}

	@Override
	public void outAThisExpression(AThisExpression node) {
		// TODO Auto-generated method stub
		super.outAThisExpression(node);
	}
}
