package com.org.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *@Author:jilongliang
 *@Date  :2013-3-7
 *@Project:JavaSE
 *@Email:jilongliang@sina.com
 *@weibo:http://weibo.com/jilongliang
 *@Description: 
 */
public class Test {
	public static void main(String[] args) {
		Test1();
		Test2();
		Test3();
		Test4();
	}

	private static void Test1() {
		String str = "love23next234csdn3423javaeye";
		str = str.trim();
		String str2 = "";
		if (str != null && !"".equals(str)) {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
					str2 += str.charAt(i);
				}
			}
		}
		System.out.println(str2);
	}

	private static void Test2() {
		// 这个就相当于你jsp传过来的request.getParamter("name");
		String a = "love23next234csdn3423javaeye";
		String regEx = "[^0-9]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(a);
		System.out.println(m.replaceAll("").trim());
	}

	private static void Test3() {
		String a = "love23next234csdn3423javaeye";
		List<String> digitList = new ArrayList<String>();
		Pattern p = Pattern.compile("[^0-9]");
		Matcher m = p.matcher(a);
		String result = m.replaceAll("");
		for (int i = 0; i < result.length(); i++) {
			digitList.add(result.substring(i, i + 1));

		}
		System.out.println(digitList);
	}

	private static void Test4() {
		String a = "love23next234csdn3423javaeye";
		List<String> ss = new ArrayList<String>();
		for (String sss : a.replaceAll("[^0-9]", ",").split(",")) {
			if (sss.length() > 0)
				ss.add(sss);
		}
		System.out.print(ss);

	}

	/**
	 * 判断一个字符串是否都为数字
	 * @param strNum
	 * @return
	 */
	public boolean isDigit1(String strNum) {
		return strNum.matches("[0-9]{1,}");
	}

	/**
	 * 判断一个字符串是否都为数字
	 * @param strNum
	 * @return
	 */
	public boolean isDigit(String strNum) {
		Pattern pattern = Pattern.compile("[0-9]{1,}");
		Matcher matcher = pattern.matcher((CharSequence) strNum);
		return matcher.matches();
	}

	/**
	 *  截取数字
	 * @param content
	 * @return
	 */
	public String getNumbers(String content) {
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			return matcher.group(0);
		}
		return "";
	}

	/**
	 *  截取非数字
	 * @param content
	 * @return
	 */
	public String splitNotNumber(String content) {
		Pattern pattern = Pattern.compile("\\D+");
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			return matcher.group(0);
		}
		return "";
	}
}
