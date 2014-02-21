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
import com.bju.cps450.parser.Parser;
import com.bju.cps450.parser.ParserException;

// a parser for the language defined @ http://sablecc3.sablecc.org/attachment/wiki/Java-1.5/java-1.5.sablecc (with basic strings added)

public class Main {
	public static void main(String[] args) throws IOException, IllegalOptionValueException, UnknownOptionException, LexerException {
		CmdLineParser parser = new CmdLineParser();
		CmdLineParser.Option help = parser.addBooleanOption('?', "help");
		//parse command line arguments
		parser.parse(args);
		
		if((Boolean)parser.getOptionValue(help, false)) {
			//display a help message
		}
		
		String source = "";
		boolean first = true;
		for(String file: parser.getRemainingArgs()) {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = reader.readLine()) != null) {
				source += ((first ? "" : "\n") + line);
				first = false;
			}
			reader.close();
		}
		
		try {
			MiniJavaLexer lexer = new MiniJavaLexer(new PushbackReader(new StringReader(source)));
			MiniJavaParser oodleParser = new MiniJavaParser(lexer);
			oodleParser.parse();
			System.out.println("success");
		} catch (LexerException e) {
			;
		} catch (ParserException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
