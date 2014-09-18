package com.prueba.primerproyecto.utils;

public class FormatUtils {
	public static final String EMPTY_STRING = "";
	
	public static Double parseDouble(CharSequence sequence){
		String string = sequence.toString();
		return Double.parseDouble(string);
	}
}
