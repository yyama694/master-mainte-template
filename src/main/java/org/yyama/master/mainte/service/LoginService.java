package org.yyama.master.mainte.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yyama.master.mainte.dao.UserDao;
import org.yyama.master.mainte.domain.UserDomain;
import org.yyama.master.mainte.dto.LoginUserFormDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class LoginService {
	@Autowired
	UserDao userDao;

	public boolean loginAuth(LoginUserFormDto dto, HttpServletRequest request) throws SQLException {
		UserDomain domain = userDao.getUserByName(dto.getName());
		if (domain == null || !dto.getPassword().equals("pass")) {
			System.out.println("domainがnullかパスワードが「pass」ではありません。");
			return false;
		}
		HttpSession session = request.getSession();
		session.setAttribute("user", domain);
		return true;
	}

	public void logout(HttpServletRequest request) {
		request.getSession().invalidate();
	}
}
