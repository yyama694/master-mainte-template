package org.yyama.master.mainte.dto;

import jakarta.validation.constraints.Size;

public class ItemFormDto {
	private final Long id;
	@Size(min = 1, max = 20, message = "{item.name.length}")
	private final String name;
	private final Long price;

	public ItemFormDto(Long id, String name, Long price) {
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
