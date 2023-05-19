package com.entity.user;

import java.util.Objects;

final public class User {
	private String name;
	private String password;

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + "]";
	}

	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, password);
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
		return Objects.equals(name, other.name) && Objects.equals(password, other.password);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
