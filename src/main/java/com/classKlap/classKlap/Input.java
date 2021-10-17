package com.classKlap.classKlap;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.classKlap.classKlap.pojo.ParkingLot;

public class Input {
	CommandLine commandLine;
	static ParkingLot parkingLot;

	public Input() {
		commandLine = new CommandLine();
		parkingLot = new ParkingLot();
	}

	public void parseTextInput(String command) {
		String[] inputs = command.split(" ");
		switch (inputs.length) {
		case 1:
			Method method = commandLine.commandLineMapping.get(command);
			if (method == null) {
				System.out.println("Invalid command");
				System.out.println();
			} else {
				try {
					method.invoke(parkingLot);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			break;
		case 2:
			Method method1 = commandLine.commandLineMapping.get(inputs[0]);
			if (method1 == null) {
				System.out.println("Invalid command");
				System.out.println();
			} else {
				try {
					method1.invoke(parkingLot, inputs[1]);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			break;
		case 3:
			Method method2 = commandLine.commandLineMapping.get(inputs[0]);
			if (method2 == null) {
				System.out.println("Invalid command");
				System.out.println();
			} else {
				try {
					method2.invoke(parkingLot, inputs[1], inputs[2]);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			break;
		default:
			System.out.println("Invalid command");
		}

	}
}
