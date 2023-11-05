package org.yyama.master.mainte.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.yyama.master.mainte.domain.UserDomain;

@Mapper
public interface UserDao {

	public List<UserDomain> getAll();

	public UserDomain getUserById(long id);

	public void delete(long id);

	public void modify(UserDomain userDomain);
	
	public long maxId();
	
	public void entry(UserDomain userDomain);
	
}
