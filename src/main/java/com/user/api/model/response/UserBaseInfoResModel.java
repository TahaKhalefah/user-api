package com.user.api.model.response;

import java.io.Serializable;

public class UserBaseInfoResModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8100753612671604511L;
	private String id;
	private String accessToken;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}
