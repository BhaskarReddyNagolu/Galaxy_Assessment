package com.virtusa.assessment.galaxy.constants;

/**
 * @author Bhaskar.N
 * 
 *   <p>
 *         This class contains the romans with name and value.
 *   </p>
 *
 */
public enum Roman {

	I("I", 1), V("V", 5), X("X", 10), L("L", 50), C("C", 100), D("D", 500), M("M", 1000);

	private String name;
	private int value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	Roman(String name, int value) {
		this.name = name;
		this.value = value;
	}
}