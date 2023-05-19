package com.entity;

import java.util.Objects;

import com.database.Data;

public class User {
	private String username;

	public User(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [username=" + username + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(username.toLowerCase());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return username.equalsIgnoreCase(other.username);	// 名字不区分大小写
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isAvailable() {
		return !Data.isContains(this);
	}
}
