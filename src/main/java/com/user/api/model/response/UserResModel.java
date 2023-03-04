package com.user.api.model.response;

import java.io.Serializable;

public class UserResModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7446977135734065449L;
	private String id;
	private String firstName;
	private String lastName;
	private boolean marketingConsent;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public boolean isMarketingConsent() {
		return marketingConsent;
	}

	public void setMarketingConsent(boolean marketingConsent) {
		this.marketingConsent = marketingConsent;
	}

}
