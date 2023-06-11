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

	private static final String URL = "jdbc:sqlite:test1.db";
	private static final String SELECT_ALL = "select * from user;";
	private static final String SELECT_USER_BY_ID = "select * from user where id = ?;";
	private static final String MODIFY_USER_BY_ID = "update user set name = ?, is_administrator =? where id = ?;";
	private static final String DELETE_USER_BY_ID = "delete from user where id = ?;";
	private static final String GET_MAX_ID = "select max(id) from user;";
	private static final String INSERT = "insert into user values(?,?,?);";
	

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

	public void modify(UserDomain user) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(MODIFY_USER_BY_ID);
		ps.setString(1, user.getName());
		ps.setString(2, user.getAdministrator().toString());
		ps.setLong(3, user.getId());
		ps.execute();
	}

	public void delete(Long id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(DELETE_USER_BY_ID);
		ps.setLong(1, id);
		ps.execute();		
	}

	public long maxId() throws SQLException {
		long max = 0;
		PreparedStatement ps = conn.prepareStatement(GET_MAX_ID);
		ResultSet rs = ps.executeQuery();
		max = rs.getLong(1);
		return ++max;
	}

	public void entry(UserDomain user) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(INSERT);
		ps.setLong(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getAdministrator().toString());		
		ps.execute();		
	}
}
