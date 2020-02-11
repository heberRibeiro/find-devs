package com.heber.backendfinddevs.util;

public class Convert {

	public static String[] StringToArray(String string) {
		return string.trim().split(",\\s|;\\s|,|;");
	}

}
