package com.bju.cps450;
import jargs.gnu.CmdLineParser;
import jargs.gnu.CmdLineParser.IllegalOptionValueException;
import jargs.gnu.CmdLineParser.UnknownOptionException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;
import java.io.StringReader;

import com.bju.cps450.lexer.LexerException;
import com.bju.cps450.node.EOF;
import com.bju.cps450.node.TComment;
import com.bju.cps450.node.TEndOfLine;
import com.bju.cps450.node.TWhitespace;
import com.bju.cps450.node.Token;

// a lexer for the language defined @ http://sablecc3.sablecc.org/attachment/wiki/Java-1.5/java-1.5.sablecc (with basic strings added)

public class Main {
	public static void main(String[] args) throws IOException, IllegalOptionValueException, UnknownOptionException, LexerException {
		CmdLineParser parser = new CmdLineParser();
		CmdLineParser.Option token = parser.addBooleanOption('t', "tokens");
		CmdLineParser.Option help = parser.addBooleanOption('?', "help");
		//parse command line arguments
		parser.parse(args);
		
		boolean shouldPrint = false;
		if((Boolean)parser.getOptionValue(token, false)) {
			shouldPrint = true;
		}
		
		if((Boolean)parser.getOptionValue(help, false)) {
			//display a help message
		}
		
		String source = "";
		boolean first = false;
		for(String file: parser.getRemainingArgs()) {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = reader.readLine()) != null) {
				source += ((first ? "" : "\n") + line);
			}
			reader.close();
		}
		
		try {
			MiniJavaLexer lexer = new MiniJavaLexer(new PushbackReader(new StringReader(source)));
			Token t;
			while(!((t = lexer.next()) instanceof EOF)) { 
				if(shouldPrint) {
					if(!(t instanceof TWhitespace || t instanceof TEndOfLine || t instanceof TComment)) {
						System.out.println(t.getLine() + " " + t.getText());
					}
				}
			}
		} catch (LexerException e) {
			;
		}
	}
}
