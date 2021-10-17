package com.classKlap.classKlap.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
	private int maximum_Size = 0;

	private class Car {
		private String registrationNo;
		private String color;

		public Car(String registrationNo, String color) {
			this.color = color;
			this.registrationNo = registrationNo;
		}
	}

	// available parking slot
	private ArrayList<Integer> availableParkingSlot;

	// slot and car
	private Map<String, Car> slotAndCar;

	// Slot number and registration number
	private Map<String, String> registrationAndSlotNumber;

	// list of registartion number and color
	private Map<String, ArrayList<String>> colorAndRegistrationNumber;

	// create parking lot
	public void createParkingLot(String parkingSlotCount) {
		this.maximum_Size = Integer.parseInt(parkingSlotCount);
		this.availableParkingSlot = new ArrayList<Integer>();
		for (int indexSlot = 1; indexSlot <= this.maximum_Size; indexSlot++) {
			this.availableParkingSlot.add(indexSlot);
		}
		this.slotAndCar = new HashMap<String, Car>();
		this.registrationAndSlotNumber = new HashMap<String, String>();
		this.colorAndRegistrationNumber = new HashMap<String, ArrayList<String>>();
		System.out.println("Created parking lot with " + this.maximum_Size + " slots");
		System.out.println();
	}

	// leave a slot
	public void leave(String slotNumber) {
		if (this.maximum_Size == 0) {
			System.out.println("Parking lot is not created");
			System.out.println();
		} else if (this.slotAndCar.size() > 0) {
			Car car = this.slotAndCar.get(slotNumber);
			if (car != null) {
				this.slotAndCar.remove(slotNumber);
				this.registrationAndSlotNumber.remove(car.registrationNo);
				this.availableParkingSlot.add(Integer.parseInt(slotNumber));
				System.out.println("Slot number " + slotNumber + " is free");
				System.out.println();
			} else {
				System.out.println("Already Empty");
				System.out.println();
			}
		} else {
			System.out.println("Parking lot is empty");
			System.out.println();
		}
	}

	// park a car
	public void park(String registrationNo, String color) {
		if (this.maximum_Size == 0) {
			System.out.println("Parking lot is not created");
			System.out.println();
		} else if (this.slotAndCar.size() == this.maximum_Size) {
			System.out.println("Sorry, Parking lot is full");
			System.out.println();
		} else {
			Collections.sort(availableParkingSlot);
			String slot = availableParkingSlot.get(0).toString();
			Car car = new Car(registrationNo, color);
			this.slotAndCar.put(slot, car);
			this.registrationAndSlotNumber.put(registrationNo, slot);
			ArrayList<String> registartionNumberList = new ArrayList<String>();
			if (this.colorAndRegistrationNumber.containsKey(color)) {
				registartionNumberList = this.colorAndRegistrationNumber.get(color);
				registartionNumberList.add(registrationNo);
				this.colorAndRegistrationNumber.put(color, registartionNumberList);
			} else {
				registartionNumberList.add(registrationNo);
				this.colorAndRegistrationNumber.put(color, registartionNumberList);
			}
			System.out.println("Allocated slot number: " + slot);
			System.out.println();
			this.availableParkingSlot.remove(0);
		}
	}

	// status of parking
	public void status() {
		if (this.maximum_Size == 0) {
			System.out.println("No Parking lot is defined");
			System.out.println();
			return;
		}
		System.out.println("Slot No.\tRegistartion No\tColor");
		Car car;
		for (int index = 1; index <= this.maximum_Size; index++) {
			String key = Integer.toString(index);
			car = this.slotAndCar.get(key);
			if (car != null)
				System.out.println(index + "  \t " + car.registrationNo + " \t " + car.color);
		}
		System.out.println();
	}

	// get all registration number of color
	public void getAllRegistrationsOfColor(String color) {
		if (this.maximum_Size == 0) {
			System.out.println("No Parking lot is defined");
			System.out.println();
			return;
		}
		if (this.colorAndRegistrationNumber.containsKey(color)) {
			ArrayList<String> registrationNos = this.colorAndRegistrationNumber.get(color);
			for (int index = 0; index < registrationNos.size(); index++) {
				if (!(index == registrationNos.size() - 1)) {
					System.out.print(registrationNos.get(index) + ",");
				} else {
					System.out.print(registrationNos.get(index));
				}
			}

		} else {
			System.out.println("Not Found");
		}
		System.out.println();
	}

	// get slot number of specific car
	public void getSlotNumberFromRegistartionNumber(String registrationNumber) {
		if (this.maximum_Size == 0) {
			System.out.println("No Parking lot is defined");
			System.out.println();
			return;
		}
		String SlotNumber = this.registrationAndSlotNumber.get(registrationNumber);
		if (SlotNumber == null) {
			System.out.println("No Slot is provided");
			System.out.println();
		} else {
			System.out.println("Slot Number" + SlotNumber);
			System.out.println();
		}

	}

	// get slot number of specific car
	public void getSlotNumbersFromColor(String color) {
		if (this.maximum_Size == 0) {
			System.out.println("No Parking lot is defined");
			System.out.println();
			return;
		}
		if (this.colorAndRegistrationNumber.containsKey(color)) {
			ArrayList<String> registrationNos = this.colorAndRegistrationNumber.get(color);
			ArrayList<String> slotNos = new ArrayList<String>();

			System.out.println();
			for (int index = 0; index < registrationNos.size(); index++) {
				slotNos.add(this.registrationAndSlotNumber.get(registrationNos.get(index)));
			}
			;
			Collections.sort(slotNos);
			for (int index = 0; index < slotNos.size(); index++) {
				if (!(index == slotNos.size() - 1)) {
					System.out.print(slotNos.get(index) + ",");
				} else {
					System.out.print(slotNos.get(index));
				}
			}
		} else {
			System.out.println("Not Found");
		}
		System.out.println();
	}
}
