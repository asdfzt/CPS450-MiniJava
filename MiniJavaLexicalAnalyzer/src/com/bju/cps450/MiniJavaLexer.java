package com.bju.cps450;

import java.io.IOException;
import java.io.PushbackReader;

import com.bju.cps450.lexer.Lexer;
import com.bju.cps450.lexer.LexerException;
import com.bju.cps450.node.TComment;
import com.bju.cps450.node.TEndOfLine;
import com.bju.cps450.node.TIllegalStr;
import com.bju.cps450.node.TUnknownCharacter;
import com.bju.cps450.node.TUnterminatedStr;
import com.bju.cps450.node.TWhitespace;
import com.bju.cps450.node.Token;

public class MiniJavaLexer extends Lexer {

	public boolean IsError(Token t) {
		return (t instanceof TUnterminatedStr || t instanceof TUnknownCharacter || t instanceof TIllegalStr);
	}
	
	public MiniJavaLexer(PushbackReader in) {
		super(in);
	}

	@Override
	protected void filter() throws LexerException, IOException {
		super.filter();
		
		if(IsError(this.token)) {
			if (this.token instanceof TUnterminatedStr) {
				System.out.println(this.token.getLine() + " unterminated string: " + this.token.getText());
			} else if (this.token instanceof TUnknownCharacter) {
				System.out.println(this.token.getLine() + " unknown character: " + this.token.getText());
			} else {
				System.out.println(this.token.getLine() + " illegal string: " + this.token.getText());
			}
		}
	}
}
