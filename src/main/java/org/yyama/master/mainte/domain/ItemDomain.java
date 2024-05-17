package org.yyama.master.mainte.domain;

public class ItemDomain {
	private final Long id;
	private final String name;
	private final Long price;

	public ItemDomain(Long id, String name, Long price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "id:" + id + "," + " name:" + name + "," + " price:" + price;
	}
}
