package com.epam.engx.cleancode.naming.task2;

import java.util.Arrays;
import java.util.Date;

public class User {

	protected boolean bAdmin = false;

	private String dBirth;

	private String sName;

	private User[] subordinateArray;

	private int iR;

	public User(String sName, String dBirth, User[] subordinateArray) {
		this.dBirth = dBirth;
		this.sName = sName;
		this.subordinateArray = subordinateArray;
	}

	@Override
	public String toString() {
		return "User [dateOfBirth=" + dBirth + ", name=" + sName + ", isAdmin=" + bAdmin + ", subordinates="
				+ Arrays.toString(subordinateArray) + ", rating=" + iR + "]";
	}

	public void setRating(int rating) {
		this.iR = rating;
	}
}
