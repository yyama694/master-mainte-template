package org.yyama.master.mainte.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.yyama.master.mainte.domain.UserDomain;

@Component
public class UserDao {

	private static final String URL = "jdbc:sqlite:D:\\opt\\sqlite\\sqlite-tools-win32-x86-3400000\\test1.db";
	private static final String SELECT_ALL = "select * from user;";
	private static final String SELECT_USER_BY_ID = "select * from user where id = ?;";

	private static Connection conn;

	public UserDao() throws SQLException {
		conn = DriverManager.getConnection(URL);
	}

	public List<UserDomain> getAll() throws SQLException {
		List<UserDomain> users = new ArrayList<>();
		PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			UserDomain u = new UserDomain((long) rs.getInt(1), rs.getString(2), Boolean.valueOf(rs.getString(3)));
			users.add(u);
			System.out.print(rs.getInt(1));
			System.out.print("\t");
			System.out.print(rs.getString(2));
			System.out.print("\t");
			System.out.print(rs.getString(3));
			System.out.println();
		}
		return users;
	}

	public UserDomain getUserById(Long id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_ID);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		UserDomain u = null;
		while (rs.next()) {
			u = new UserDomain((long) rs.getInt(1), rs.getString(2), Boolean.valueOf(rs.getString(3)));
		}
		System.out.println("getUserById " + u);
		return u;
	}

	public void modify(UserDomain user) {
//		for (UserDomain userDomain : users) {
//			if (user.getId() == userDomain.getId()) {
//				users.remove(userDomain);
//				break;
//			}
//		}
//		users.add(user);
	}

	public void delete(Long id) {
//		for (UserDomain userDomain : users) {
//			if (id == userDomain.getId()) {
//				users.remove(userDomain);
//				break;
//			}
//		}
	}

	public long maxId() {
		long max = 0;
//		for (UserDomain userDomain : users) {
//			max = Math.max(max, userDomain.getId());
//		}
		return ++max;
	}

	public void entry(UserDomain user) {
//		users.add(user);
	}
}
