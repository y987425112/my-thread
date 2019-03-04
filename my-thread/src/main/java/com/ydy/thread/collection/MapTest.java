package com.ydy.thread.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 并发map
 * @author ydy
 * */
public class MapTest {
	public static void main(String[] args) {
		HashMap<String, Integer> map=new HashMap<>();
		ConcurrentHashMap<String, Integer> concurrentHashMap=new ConcurrentHashMap<>();
		map.put("abc", 1);
	}

}
