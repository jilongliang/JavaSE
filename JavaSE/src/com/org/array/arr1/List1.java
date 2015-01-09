package com.org.array.arr1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 *@Author:jilongliang
 *@Date :2013-3-7
 *@Project:JavaSE
 *@Class:List1.java
 *@Description:
 */
@SuppressWarnings("all")
public class List1 {
	/**
	 * Collection List:元素是有序的,可以重复的，因为该集合有索引 Set:元素是无序的，不可以重复的
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		List list = new ArrayList();// ArrayList list=new ArrayList();

		list.add("list1");
		list.add("list2");
		list.add("list3");
		// 指定一个下标添加一个元素
		list.add(1, "指定下标为1的索引添加一个元素,也就是第二元素");

		System.out.println(list);

		// 删除指定的一个下标索引的值
		list.remove(1);
		System.out.println(list);

		// 修改指定的一个下标的值
		list.set(2, "这个值给我修改啦");
		System.out.println(list);

		// 获取出所有值
		for (int i = 0; i < list.size(); i++) {
			System.out.println("第" + i + "个=" + list.get(i));
		}
		// Iterator迭代循环
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		System.out.println(list.indexOf("list1"));
		// 获取1-3的值包含3
		List l = list.subList(1, 3);
		System.out.println(l);

		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			if (obj.equals("list2")) {
				// 这里迭代出来的时候不能添加一个数据进去，由于并发问题java.util.ConcurrentModificationException
				// list.add("添加一个");
				list.remove("list2");// 删除是可以的
				System.out.println(list);
			}
		}
	}
}
