package org.yyama.master.mainte.dto;

public class LoginUserDto {
	private final Long id;
	private final String name;
	private final Boolean administrator;

	public LoginUserDto(Long id, String name, Boolean administrator) {
		this.id = id;
		this.name = name;
		this.administrator = administrator;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Boolean getAdministrator() {
		return administrator;
	}

	@Override
	public String toString() {
		return "id:" + id + "," + " name:" + name + "," + " administrator:" + administrator;
	}
}
