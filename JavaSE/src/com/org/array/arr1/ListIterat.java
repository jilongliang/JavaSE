package com.org.array.arr1;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 *@Author:jilongliang
 *@Date :2013-3-7
 *@Project:JavaSE
 *@Class:ListIterator.java
 *@Description:
 */
@SuppressWarnings("all")
public class ListIterat {

	public static void main(String[] args) {
		List list = new ArrayList();// ArrayList list=new ArrayList();
		list.add("list1");
		list.add("list2");
		list.add("list3");
		ListIterator listIter = list.listIterator();
		System.out.println(listIter.hasPrevious());
		while (listIter.hasNext()) {
			Object obj = listIter.next();
			if (obj.equals("list2")) {
				// listIter.add("添加一个");
				listIter.set("我修改啦");
				System.out.println(list);
				System.out.println(listIter.hasPrevious()); // 判断有没有前一个数
			}
		}
	}
}
