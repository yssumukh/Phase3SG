package com.Phase3project.Phase3projsocgen.Entity;

public class SigninResponse {
	private String username;
	private String token;
	private boolean admin;
	private long expiresIn;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public SigninResponse(String username, String token, boolean admin) {
		super();
		this.username = username;
		this.admin = admin;
		
	}

	public SigninResponse(String string, String string2) {
		super();
	}

}
