package com.axiom.mobile.model;

public enum SimType {
	No("No"), Micro_SIM("Micro-SIM"), Mini_SIM("Mini-SIM"), Nano_SIM("Nano-SIM"), eSIM("eSIM");

	private final String name;

	private SimType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}