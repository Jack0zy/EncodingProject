package com.validation.java;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.owasp.encoder.Encode;

public class J_Validate {
	
	public static void main(String[] args) {
		String original = "hjdg$'<></>h&jk8^i0sv ssh6/";
		HashMap<String, String> processedData = processorMethod(original);
		System.out.println(processedData.toString());
	}

	public static HashMap<String, String> processorMethod(String original) {
		HashMap<String, String> processedData = new HashMap<String, String>();

		String encoded = "";
		String specialCharacterRemoved = original;
		Pattern pt = Pattern.compile("[^a-zA-Z0-9]");
		Matcher match = pt.matcher(original);
		boolean isSpecialCharacterPresent = false;
		while (match.find()) {
			isSpecialCharacterPresent = true;
			String s = match.group();
			specialCharacterRemoved = specialCharacterRemoved.replaceAll("\\" + s, "");

		}
		if (isSpecialCharacterPresent) {

			encoded = Encode.forUriComponent(original);
		}
		processedData.put("characters removed", specialCharacterRemoved);
		processedData.put("encoded", encoded);
		processedData.put("original", original);

		return processedData;
	}
}