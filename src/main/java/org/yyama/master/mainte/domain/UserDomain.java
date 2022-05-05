package org.yyama.master.mainte.domain;

public class UserDomain {
	private final Long id;
	private final String name;
	private final Boolean administrator;

	public UserDomain(Long id, String name, Boolean administrator) {
		super();
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
}
