package com.org.array.arr1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:jilongliang
 * @Date :2013-3-5
 * @Project:JavaSE
 * @Class:Map1.java
 */
public class Map1 {
	/**
	 * Hashtable:底层是哈希表结构数据，不可以存入null键和null值,该集合是线程同步，jdk1.0引入效率低
	 * HashMap:底层是哈希表结构数据，允许存入null键和null值,该集合是线程不同步,jdk1.2引入效率高
	 * TreeMap:底层是二叉树数据机构，线程不同步,可以用于给Map集合中的键进行排序
	 */
	public static void main(String[] args) {
		// 当添加元素的时,key是相同的话,后面的值会覆盖之前的key对应的值
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");

		System.out.println(map.containsKey("key11")); // 若这个key存在就返回一个true,反之返回一个false

		map.put(null, "HashMap可以存放null值和null键");
		map.put("key4", null); // null值
		System.out.println("get:" + map.get(null) + "\tget:" + map.get("key4"));

		map.remove("key3");// 移除key值

		System.out.println("移除key值:" + map.get("key3"));

		System.out.println(map); // 输出移除之后的map

		Collection<String> coll = map.values();// 获取所有集合的值

		System.out.println(coll);

	}
}
