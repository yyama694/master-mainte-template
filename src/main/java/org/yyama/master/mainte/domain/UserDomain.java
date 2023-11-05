package org.yyama.master.mainte.domain;

/*
 * このシステムにおいてUserDomainとUserFormDtoは分ける必要性を感じられないが、
 * 多少複雑なシステムになると画面のフォーム受け取り用DTOのプロパティと、
 * ドメインのプロパティが必ずしも一致しない（むしろ一致する方が珍しいかも）ので
 * 明示的に分けた。
 */
public class UserDomain {
	private final Long id;
	private final String name;
	private final Boolean administrator;

	public UserDomain(Long id, String name, Boolean administrator) {
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
