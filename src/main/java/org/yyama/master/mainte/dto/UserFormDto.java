package org.yyama.master.mainte.dto;

import jakarta.validation.constraints.Size;

public class UserFormDto {
	private final Long id;
	@Size(min = 1, max = 20, message = "{user.name.length}")
	private final String name;
	private final Boolean administrator;

	public UserFormDto(Long id, String name, Boolean administrator) {
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
