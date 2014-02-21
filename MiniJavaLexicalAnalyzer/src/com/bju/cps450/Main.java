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

// a lexer for the language defined @ http://sablecc3.sablecc.org/attachment/wiki/Java-1.5/java-1.5.sablecc (with basic strings added)

public class Main {
	//create an options instance that can be passed to the lexer and parser
	private static Options opt = new Options();
	
	public static void main(String[] args) throws IOException, IllegalOptionValueException, UnknownOptionException, LexerException {
		String[] files = parseCommandLine(args);
		
		//read all files in and concatenate them together
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
		
		try {
			MiniJavaLexer lexer = new MiniJavaLexer(new PushbackReader(new StringReader(source)), opt);
			while(!(lexer.next() instanceof EOF)) { 
				;
			}
		} catch (LexerException e) {
			;
		}
	}
	
	private static String[] parseCommandLine(String[] args) throws IllegalOptionValueException, UnknownOptionException {
		CmdLineParser parser = new CmdLineParser();
		CmdLineParser.Option token = parser.addBooleanOption('t', "tokens");
		CmdLineParser.Option help = parser.addBooleanOption('?', "help");
		//parse command line arguments
		parser.parse(args);
		
		opt.shouldPrintTokens = false;
		if((Boolean)parser.getOptionValue(token, false)) {
			opt.shouldPrintTokens = true;
		}
		
		if((Boolean)parser.getOptionValue(help, false)) {
			//display a help message
			System.exit(0);
		}
		
		return parser.getRemainingArgs();
	}
}
