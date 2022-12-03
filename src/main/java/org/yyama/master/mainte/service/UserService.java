package org.yyama.master.mainte.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yyama.master.mainte.dao.UserDao;
import org.yyama.master.mainte.domain.UserDomain;

@Service
public class UserService {
	@Autowired
	UserDao userDao;

	public List<UserDomain> getUsers() throws SQLException {
		return userDao.getAll();
	}

	public UserDomain getUserById(Long id) throws SQLException {
		return userDao.getUserById(id);
	}

	public void deleteUserById(Long id) {
		userDao.delete(id);
	}

	public void modify(UserDomain user) {
		userDao.modify(user);
	}

	public UserDomain newUser() {
		return new UserDomain(userDao.maxId(), null, false);
	}

	public void entryComplete(UserDomain user) {
		userDao.entry(user);
	}

}
