package com.bju.cps450;

import com.bju.cps450.utilities.Errors;
import com.bju.cps450.utilities.Options;

public class Application {
	private static Options options;
	private static Errors errors;
	
	public static Options getOptions() {
		if(options == null) {
			options = new Options();
		}
		return options;
	}
	
	public static Errors getErrors() {
		if(errors == null) {
			errors = new Errors();
		}
		return errors;
	}
}
