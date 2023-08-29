package com.nishassoni.beans;

public class Student {
	
	private int id;
	
	private String firstName;
	
	private String lasstName;

	public Student(int id, String firstName, String lasstName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lasstName = lasstName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLasstName() {
		return lasstName;
	}

	public void setLasstName(String lasstName) {
		this.lasstName = lasstName;
	}
	
	

}
