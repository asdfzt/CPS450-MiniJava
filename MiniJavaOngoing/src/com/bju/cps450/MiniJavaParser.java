package com.bju.cps450;

import java.io.IOException;

import com.bju.cps450.lexer.Lexer;
import com.bju.cps450.lexer.LexerException;
import com.bju.cps450.node.EOF;
import com.bju.cps450.node.Start;
import com.bju.cps450.parser.Parser;
import com.bju.cps450.parser.ParserException;

public class MiniJavaParser extends Parser {

	Lexer lexer;
	
	public MiniJavaParser(Lexer lexer) {
		super(lexer);
		this.lexer = lexer;
	}

	@Override
	public Start parse() throws LexerException, IOException {
		try {
			return super.parse();
		} catch (ParserException e) {
			Application.getErrors().addParserErrors();
			System.out.println(e);
			System.out.println(this.lexer.peek().getClass().toString() + " " + this.lexer.peek().getText());
			while(!(lexer.next() instanceof EOF)) { ; }
		}
		return null;
	}
}