package org.yyama.master.mainte.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.yyama.master.mainte.domain.ItemDomain;

@Mapper
public interface ItemDao {

	public List<ItemDomain> getAll();

	public ItemDomain getItemById(long id);

	public void delete(long id);

	public void modify(ItemDomain itemDomain);
	
	public long maxId();
	
	public void entry(ItemDomain itemDomain);

}
