package com.org.array.arr1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *@Author:jilongliang
 *@Date :2013-3-5
 *@Project:JavaSE
 *@Class:Map2.java
 *@Description:
 */
public class Map2 {
	/**
	 * map:集合的两种取出方式 
	 * 1.keySet:将map中的所有key存入到Set集合，因为Set具有迭代器
	 * ,可以迭代方式获取所有的key,在根据get方法,获取所有对于的值
	 * 2.entrySet:将map集合中的映射关系存入到了Set集合中,而这个关系的数据类型就是Map.Entry
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		// 先获取map集合的所有key的Set集合
		Set<String> keySet = map.keySet();
		// 有了Set集合，就可以获取其迭代器
		Iterator<String> iter = keySet.iterator();
		/*
		 * 过程原理是: Map---->Set存放Map的key---->迭代器获取出value
		 */
		// 循环遍历
		while (iter.hasNext()) {
			String key = iter.next();
			String value = map.get(key);// 通过map的get获取值
			System.out.println("key:" + key + "\t value:" + value);
		}
	}

}
