package com.entity;

import java.util.Objects;

public class Msg {
	private String msg;
	private User user;

	public Msg(String msg, User user) {
		super();
		this.msg = msg;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Msg [msg=" + msg + ", user=" + user + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(msg, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Msg other = (Msg) obj;
		return Objects.equals(msg, other.msg) && Objects.equals(user, other.user);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
