package com.database;

import java.util.HashSet;
import java.util.Set;

import com.entity.User;

public class Data {
	private static Set<User> users;
	
	static {
		users = new HashSet<User>();
		
		// 三个常驻用户
		users.add(new User("ZhangSan"));
		users.add(new User("LiSi"));
		users.add(new User("WangWu"));
	}
	
	public static Set<User> getAll() {
		return users;
	}
	
	public static boolean isContains(User user) {
		return users.contains(user);
	}

	public static void addOne(User user) {
		users.add(user);
	}
}
