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
import com.bju.cps450.node.Start;
import com.bju.cps450.utilities.Options;

// a lexer for the language defined @ http://sablecc3.sablecc.org/attachment/wiki/Java-1.5/java-1.5.sablecc (with basic strings added)

public class Main {
	public static void main(String[] args) throws IOException, IllegalOptionValueException, UnknownOptionException, LexerException {
		String[] files = parseCommandLine(args);
		
		String source = "";
		boolean first = false;
		for(String file: files) {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = reader.readLine()) != null) {
				source += ((first ? "" : "\n") + line);
			}
			reader.close();
		}
		
		MiniJavaLexer lexer = new MiniJavaLexer(new PushbackReader(new StringReader(source)));
		MiniJavaParser parser = new MiniJavaParser(lexer);
		Start s = parser.parse();
		if(Application.getErrors().getTotalErrors() == 0) {
			MiniJavaSemanticChecker semanticChecker = new MiniJavaSemanticChecker();
			
			s.apply(semanticChecker);
		}
	}
	
	private static String[] parseCommandLine(String[] args) throws IllegalOptionValueException, UnknownOptionException {
		CmdLineParser parser = new CmdLineParser();
		CmdLineParser.Option token = parser.addBooleanOption('t', "tokens");
		CmdLineParser.Option help = parser.addBooleanOption('?', "help");
		//parse command line arguments
		parser.parse(args);
		
		Application.getOptions().shouldPrintTokens = false;
		if((Boolean)parser.getOptionValue(token, false)) {
			Application.getOptions().shouldPrintTokens = true;
		}
		
		if((Boolean)parser.getOptionValue(help, false)) {
			//display a help message
			System.exit(0);
		}
		
		return parser.getRemainingArgs();
	}
}
