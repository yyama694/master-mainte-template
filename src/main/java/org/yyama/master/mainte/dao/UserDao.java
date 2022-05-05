package org.yyama.master.mainte.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.yyama.master.mainte.domain.UserDomain;

@Component
public class UserDao {
	public static final List<UserDomain> users;
	static {
		users = new ArrayList<>();
		UserDomain user = new UserDomain(1L, "山田　太郎", false);
		users.add(user);
		UserDomain user2 = new UserDomain(2L, "川田　二郎", false);
		users.add(user2);
	}

	public List<UserDomain> getAll() {
		return users;
	}

	public UserDomain getUserById(Long id) {
		for (UserDomain userDomain : users) {
			if (id == userDomain.getId()) {
				return userDomain;
			}
		}
		return null;
	}

	public void modify(UserDomain user) {
		for (UserDomain userDomain : users) {
			if (user.getId() == userDomain.getId()) {
				users.remove(userDomain);
				break;
			}
		}
		users.add(user);
	}
}
