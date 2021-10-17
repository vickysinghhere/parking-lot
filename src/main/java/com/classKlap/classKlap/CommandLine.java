package com.classKlap.classKlap;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.classKlap.classKlap.pojo.ParkingLot;

public class CommandLine {
	public Map<String, Method> commandLineMapping;

	public CommandLine() {
		commandLineMapping = new HashMap<String, Method>();
		try {
			populateCommandLine();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	private void populateCommandLine() throws NoSuchMethodException, SecurityException {
		commandLineMapping.put("create_parking_lot", ParkingLot.class.getMethod("createParkingLot", String.class));
		commandLineMapping.put("park", ParkingLot.class.getMethod("park", String.class, String.class));
		commandLineMapping.put("status", ParkingLot.class.getMethod("status"));
		commandLineMapping.put("leave", ParkingLot.class.getMethod("leave", String.class));
		commandLineMapping.put("registration_numbers_for_cars_with_colour",
				ParkingLot.class.getMethod("getAllRegistrationsOfColor", String.class));
		commandLineMapping.put("slot_numbers_for_cars_with_colour",
				ParkingLot.class.getMethod("getSlotNumbersFromColor", String.class));
		commandLineMapping.put("slot_number_for_registration_number",
				ParkingLot.class.getMethod("getSlotNumberFromRegistartionNumber", String.class));
	}
}
