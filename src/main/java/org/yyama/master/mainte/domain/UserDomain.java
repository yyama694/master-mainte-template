package org.yyama.master.mainte.domain;

public class UserDomain {
	private final Long id;
	private final String name;
	private final boolean administrator;

	public UserDomain(Long id, String name, boolean administrator) {
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

	public boolean isAdministrator() {
		return administrator;
	}
}
