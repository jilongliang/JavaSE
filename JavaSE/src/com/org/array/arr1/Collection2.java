package com.org.array.arr1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * @Author:jilongliang
 * @Date :2013-3-8
 * @Project:JavaSE
 * @Class:Collection1.java
 * @Description:
 */
public class Collection2 {
	public static void main(String[] args) {
		reverseOrder1();
		suffle();
	}

	public static void reverseOrder1() {
		// TreeSet<String> list = new
		// TreeSet<String>(Collections.reverseOrder()); //reverseOrder排序反转
		TreeSet<String> list = new TreeSet<String>(Collections
				.reverseOrder(new LegthCompare()));
		list.add("abc");
		list.add("ddd");
		list.add("bbb");
		list.add("ccc");
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public static void copy1() {
		List<String> srcList = new ArrayList<String>();
		srcList.add("拷贝");
		srcList.add("拷贝");
		List<String> dest = new ArrayList<String>(Arrays
				.asList(new String[srcList.size()]));

		// 开始拷贝
		Collections.copy(dest, srcList);
		for (Object s : dest) {
			System.out.println("拷贝之后的数据：" + s);
		}
	}

	public static void copy2() {
		List<String> src = new ArrayList<String>();
		src.add("111");
		src.add("222");
		src.add("333");
		src.add("444");
		List<String> dest1 = new ArrayList<String>();
		Collections.addAll(dest1, new String[src.size()]);
		Collections.copy(dest1, src);
		for (Object s : dest1) {
			System.out.println(s);
		}
	}

	public static void suffle() {// 隨機
		List<String> src = new ArrayList<String>();
		src.add("111");
		src.add("222");
		src.add("333");
		src.add("444");
		Collections.shuffle(src);
		for (Object s : src) {
			System.out.println(s);
		}
	}

	/**
	 * 长度的比较
	 */
	static class LegthCompare implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			if (o1.length() > o2.length()) {
				return 1;
			}
			if (o1.length() < o2.length()) {
				return -1;
			}
			return o1.compareTo(o2);
		}
	}

	static class Compare implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			/*
			 * int num=o1.compareTo(o2); if(num>0) return -1; if(num<0) return
			 * 1; return num;
			 */
			return o2.compareTo(o1);// 反转输出
		}
	}

}
