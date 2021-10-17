package com.classKlap.classKlap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		Input input = new Input();
		switch (args.length) {
		case 0:
			System.out.println("Please enter 'exit' to quit");
			System.out.println("Write your command...");

			for (;;) {
				BufferedReader buffererReader = new BufferedReader(new InputStreamReader(System.in));
				try {
					String inputString = buffererReader.readLine();
					if (inputString.equals("exit")) {
						System.out.println("bye...");
						break;
					} else {
						input.parseTextInput(inputString);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			break;
		case 1:
			break;
		default:
			System.out.println("Wrong Input , No command Found");
		}
	}
}