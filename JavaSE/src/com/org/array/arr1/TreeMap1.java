package com.org.array.arr1;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *@Author:jilongliang
 *@Date :2013-3-5
 *@Project:JavaSE
 *@Class:TreeMap1.java
 *@Description:
 */
public class TreeMap1 {

	public static void main(String[] args) {
		/**
		 *TreeMap 底层是二叉树数据机构，线程不同步,可以用于给Map集合中的键进行排序
		 */
		TreeMap<String, String> treeMap = new TreeMap<String, String>();
		treeMap.put("key1", "value1");
		treeMap.put("key2", "value2");
		treeMap.put("key4", "value4");
		treeMap.put("key3", "value3");
		// 将Map集合中的映射关系区出来，存入到Set集合中
		Set<Map.Entry<String, String>> entrySet = treeMap.entrySet();
		//
		Iterator<Map.Entry<String, String>> iter = entrySet.iterator();
		while (iter.hasNext()) {
			Map.Entry<String, String> me = iter.next();
			String key = me.getKey();// 获取key
			String value = me.getValue();// 获取value
			System.out.println("key：" + key + "\t value:" + value);
		}
	}
}
