package com.heber.backend.resources.util;

import java.util.ArrayList;
import java.util.List;

public class Convert {

	public static String[] StringToArray(String text) {
		return text.trim().split(",\\s|;\\s|,|;");
	}

	public static List<String> StringToArrayList(String text) {

		List<String> textArrayList = new ArrayList<String>();
		String[] textArray = Convert.StringToArray(text);

		for (String e : textArray) {
			textArrayList.add(e);
		}

		return textArrayList;
	}

}
