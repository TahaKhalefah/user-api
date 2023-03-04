package com.user.api.model.request;

import java.io.Serializable;

public class UserReqModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6461401933738280520L;
	private String firstName;
	private String lastName;
	private String email;
	private boolean marketingConsent;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isMarketingConsent() {
		return marketingConsent;
	}

	public void setMarketingConsent(boolean marketingConsent) {
		this.marketingConsent = marketingConsent;
	}

}
