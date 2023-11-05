package org.yyama.master.mainte.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yyama.master.mainte.dao.UserDao;
import org.yyama.master.mainte.domain.UserDomain;
import org.yyama.master.mainte.dto.UserFormDto;

@Service
public class UserService {
	@Autowired
	UserDao userDao;

	public List<UserDomain> getUsers() throws SQLException {
		return userDao.getAll();
	}

	public UserFormDto getUserById(Long id) throws SQLException {
		UserDomain userDomain = userDao.getUserById(id);
		UserFormDto userFormDto = new UserFormDto(userDomain.getId(), userDomain.getName(),
				userDomain.getAdministrator());
		return userFormDto;
	}

	public void deleteUserById(Long id) throws SQLException {
		userDao.delete(id);
	}

	public void modify(UserFormDto userFormDto) throws SQLException {
		UserDomain userDomain = new UserDomain(userFormDto.getId(), userFormDto.getName(),
				userFormDto.getAdministrator());

		userDao.modify(userDomain);
	}

	public UserDomain newUser() throws SQLException {
		return new UserDomain(userDao.maxId() + 1, null, false);
	}

	public void entry(UserFormDto userFormDto) throws SQLException {
		UserDomain userDomain = new UserDomain(userFormDto.getId(), userFormDto.getName(),
				userFormDto.getAdministrator());
		userDao.entry(userDomain);
	}

}
