package org.yyama.master.mainte.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.yyama.master.mainte.domain.UserDomain;

@Component
public class UserDao {
	public List<UserDomain> getAll() {
		List<UserDomain> list = new ArrayList<>();
		UserDomain user = new UserDomain(1L, "山田　太郎", false);
		list.add(user);
		return list;
	}
}
