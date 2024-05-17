package org.yyama.master.mainte.dto;

public class LoginUserFormDto {
	private final String name;
	private final String password;

	public LoginUserFormDto(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "name:" + name + "," + " password:" + password;
	}
}
