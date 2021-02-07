package com.epam.engx.cleancode.naming.task2;

import java.util.Arrays;
import java.util.Date;

public class User {

	protected boolean isAdmin = false;

	private String dateOfBirth;

	private String name;

	private User[] subordinateArray;

	private int rating;

	public User(String Name, String dateOfBirth, User[] subordinateArray) {
		this.dateOfBirth = dateOfBirth;
		this.name = name;
		this.subordinateArray = subordinateArray;
	}

	@Override
	public String toString() {
		return "User [dateOfBirth=" + dateOfBirth + ", name=" + name + ", isAdmin=" + isAdmin + ", subordinates="
				+ Arrays.toString(subordinateArray) + ", rating=" + rating + "]";
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
