package com.org.array.arr1;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 *@Author:jilongliang
 *@Date :2013-3-5
 *@Project:JavaSE
 *@Class:HashTable.java
 *@Description:
 */
public class HashTable {
	public static void main(String[] args) {
		/**
		 * Hashtable:底层是哈希表结构数据，不可以存入null键和null值,该集合是线程同步，jdk1.0引入效率低
		 * HashMap:底层是哈希表结构数据，允许存入null键和null值,该集合是线程不同步,jdk1.2引入效率高
		 * TreeMap:底层是二叉树数据机构，线程不同步,可以用于给Map集合中的键进行排序
		 */
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("key1", "第一个Value");
		map2.put("key2", "第二个value2");
		map2.put("key3", "第三个value3");
		System.out.println(map2);

		// Hashtable:底层是哈希表结构数据，不可以存入null键和null值,该集合是线程同步，jdk1.0引入效率低
		Map<String, String> map1 = new Hashtable<String, String>();
		map1.put("key1", "第一个Value");
		map1.put("key2", "第二个value2");
		map1.put("key3", "第三个value3");
		//加上这个 行代码测试可以看到结果会报java.lang.NullPointerException
		//map1.put(null, "Hashtable的键和value不可以为null"); 
		System.out.println(map1);
	}
}
