package com.rest.api.post;

public class USERPOJO1 {
	private String first_name;
	private String last_name;
	private String gender;
	private String email;
	private String status;

	// Getter Methods

	public USERPOJO1(String fname, String lname, String gender, String email, String status) {
		this.first_name=fname;
		this.last_name=lname;
		this.gender=gender;
		this.email=email;
		this.status=status;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getGender() {
		return gender;
	}

	public String getEmail() {
		return email;
	}

	public String getStatus() {
		return status;
	}

	// Setter Methods

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}