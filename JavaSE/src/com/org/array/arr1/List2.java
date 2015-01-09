package com.org.array.arr1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *@Author:jilongliang
 *@Date :2013-3-7
 *@Project:JavaSE
 *@Class:List1.java
 *@Description:
 */
@SuppressWarnings("all")
public class List2 {
	/**
	 * Collection List:元素是有序的,可以重复的，因为该集合有索引 Set:元素是无序的，不可以重复的
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		List list1 = new ArrayList();// ArrayList list=new ArrayList();

		list1.add("list1");
		list1.add("list2");
		list1.add("list3");

		List list2 = new ArrayList();
		list2.add("list1");
		list2.add("list3");
		list2.add("list4");

		list1.retainAll(list2);
		System.out.println("取交集" + list1);
		System.out.println("取交集" + list2);

		if (list1.contains("list2")) {
			System.out.println("包含有list2");
		}

		System.out.println("清除之前" + list1);
		list1.clear();// 清除
		System.out.println("清除之后" + list1);
		list1.removeAll(list1);
		System.out.println("移除之後" + list1);

	}
}
