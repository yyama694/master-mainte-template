package org.yyama.master.mainte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yyama.master.mainte.dao.UserDao;
import org.yyama.master.mainte.domain.UserDomain;

@Service
public class UserService {
	@Autowired
	UserDao userDao;

	public List<UserDomain> getUsers() {
		return userDao.getAll();
	}

}
