package com.entity;

import java.util.Objects;

public class DataItem {
	private Computer computer;
	private Admin admin;

	public DataItem(Computer computer, Admin admin) {
		super();
		this.computer = computer;
		this.admin = admin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(computer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataItem other = (DataItem) obj;
		return Objects.equals(computer, other.computer);
	}

	@Override
	public String toString() {
		return "DataItem [computer=" + computer + ", admin=" + admin + "]";
	}

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
}
