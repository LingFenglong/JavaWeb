package com.database;

import java.util.HashSet;
import java.util.Set;

import com.entity.Computer;
import com.entity.DataItem;
import com.entity.Admin;

public class Data {
	private static Set<DataItem> dataItems = new HashSet<>();
	
	static {
		dataItems.add(new DataItem(new Computer("huawei", "black", 9999), new Admin("ZhangSan")));
	}
	
	public static Set<DataItem> getAll() {
		return dataItems;
	}
	
	public static boolean addOne(DataItem dataItem) {
		return dataItems.add(dataItem);
	}
}
