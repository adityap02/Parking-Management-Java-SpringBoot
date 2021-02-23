package com.epam.engx.cleancode.naming.task3;

public class HarshadNumbers {

	public String main() {
		StringBuilder result = new StringBuilder();
		long limit = 200; 
		for (int i = 1; i <= limit; i++) {
			if (i % loop(i) == 0) {
				result.append(i).append("\n");
			}
		}
		return result.toString();
	}

	private int loop(int number) {
		int sum = 0;
		while (number != 0) {
            sum += number % 10;
            number = number / 10;
        }
		return sum;
	}

}
