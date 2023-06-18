package com;

import java.util.Objects;

public class User {
	private String username;
	private String password;
	private String realname;
	private int state;
	private int failCount;

	public User(String username, String password, String realname, int state, int failCount) {
		super();
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.state = state;
		this.failCount = failCount;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", realname=" + realname + ", state=" + state
				+ ", failCount=" + failCount + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(username);
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
		return Objects.equals(username, other.username);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getFailCount() {
		return failCount;
	}

	public void setFailcount(int failcount) {
		this.failCount = failcount;
	}
}
