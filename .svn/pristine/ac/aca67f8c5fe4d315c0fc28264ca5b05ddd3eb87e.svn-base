package com.example.niu.myapplication.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Judge {

	static public boolean isMobile(String number) {
		return Pattern.matches("^1[3456789]\\d{9}$",number);
	}
	
	/**
	 * ����û����Ϸ���
	 * @param userName
	 * @return
	 */
	public static boolean isUsername(String username) {
		String regex = "([a-z]|[A-Z]|[0-9]|[\\u4e00-\\u9fa5])+";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(username);
		return m.matches();
	}
}
