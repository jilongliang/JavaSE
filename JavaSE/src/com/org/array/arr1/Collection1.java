package com.org.array.arr1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author:jilongliang
 * @Date :2013-3-8
 * @Project:JavaSE
 * @Class:Collection1.java
 * @Description:
 */
public class Collection1 {
	public static void main(String[] args) {
		binarySearch1();
	}

	public static void binarySearch1() {
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("ddd");
		list.add("bbb");
		list.add("ccc");
		Collections.sort(list);
		int index = Collections.binarySearch(list, "ccc");
		int index1 = hashSearch(list, "ccc");
		int index2 = hashSearch1(list, "cccc", new LegthCompare());
		System.out.println(index2);
		System.out.println(list);
	}

	public static int hashSearch(List<String> list, String key) {
		int max, min, mid;
		max = list.size() - 1;
		min = 0;
		while (min <= max) {
			mid = (max + min) >> 1;
			String str = list.get(mid);
			int num = str.compareTo(key);
			if (num > 0) {
				max = mid - 1;
			} else if (num < 0) {
				min = mid + 1;
			} else {
				return mid;
			}
		}
		return -min - 1;
	}

	/**
	 * 
	 * @param list
	 * @param key
	 * @param comp
	 * @return
	 */
	public static int hashSearch1(List<String> list, String key,
			Comparator<String> comp) {
		int max, min, mid;
		max = list.size() - 1;
		min = 0;
		while (min <= max) {
			mid = (max + min) >> 1;
			String str = list.get(mid);
			int num = comp.compare(str, key);
			if (num > 0) {
				max = mid - 1;
			} else if (num < 0) {
				min = mid + 1;
			} else {
				return mid;
			}
		}
		return -min - 1;
	}
}

class LegthCompare implements Comparator<String> {

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
