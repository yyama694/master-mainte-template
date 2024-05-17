package org.yyama.master.mainte.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yyama.master.mainte.dao.ItemDao;
import org.yyama.master.mainte.domain.ItemDomain;
import org.yyama.master.mainte.dto.ItemFormDto;

@Service
public class ItemService {
	@Autowired
	ItemDao itemDao;

	public List<ItemDomain> getUsers() throws SQLException {
		return itemDao.getAll();
	}

	public ItemFormDto getItemById(Long id) throws SQLException {
		ItemDomain itemDomain = itemDao.getItemById(id);
		ItemFormDto itemFormDto = new ItemFormDto(itemDomain.getId(), itemDomain.getName(),
				itemDomain.getPrice());
		return itemFormDto;
	}

	public void deleteItemById(Long id) throws SQLException {
		itemDao.delete(id);
	}

	public void modify(ItemFormDto itemFormDto) throws SQLException {
		ItemDomain itemDomain = new ItemDomain(itemFormDto.getId(), itemFormDto.getName(), itemFormDto.getPrice());

		itemDao.modify(itemDomain);
	}

	public ItemDomain newUser() throws SQLException {
		return new ItemDomain(itemDao.maxId() + 1, null, 0L);
	}

	public void entry(ItemFormDto itemFormDto) throws SQLException {
		ItemDomain itemDomain = new ItemDomain(itemFormDto.getId(), itemFormDto.getName(), itemFormDto.getPrice());
		itemDao.entry(itemDomain);
	}

}
