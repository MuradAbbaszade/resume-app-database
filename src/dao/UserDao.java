package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import abstractdao.AbstractUserDao;
import entity.User;

public class UserDao extends AbstractUserDao {
	@Override
	public List<User> getAll() {
		List<User> list = new ArrayList<>();
		Connection conn;
		try {
			conn = connect();

			Statement stmt = conn.createStatement();
			stmt.execute("SELECT * from users ");
			ResultSet rs = stmt.getResultSet();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String nationality = rs.getString("nationality");
				User u = new User(id, name, surname, email, phone, nationality);
				list.add(u);

			}
		} catch (Exception ex) {

		}
		return list;
	}

	@Override
	public User getById(int userId) throws Exception {
		User us = null;
		Statement s = connect().createStatement();
		s.execute("Select * from users where id=" + userId);
		ResultSet rs = s.getResultSet();
		rs.next();
		String name = rs.getString("name");
		String surname = rs.getString("surname");
		String email = rs.getString("email");
		String phone = rs.getString("phone");
		String nationality = rs.getString("nationality");
		us = new User(userId, name, surname, email, phone, nationality);
		return us;
	}

	@Override
	public boolean updateUser(User u) {
		Connection conn;
		boolean b = true;
		try {
			conn = connect();
			PreparedStatement stmt = conn.prepareStatement(
					"UPDATE users SET name=? , surname=? , email = ? , phone = ?,nationality = ?  WHERE id= ?;");
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getSurname());

			stmt.setString(3, u.getEmail());
			stmt.setString(4, u.getPhone());

			stmt.setString(5, u.getNationality());

			stmt.setInt(6, u.getId());
			b = stmt.execute();

		} catch (Exception ex) {
			System.err.println(ex);
			b = false;
		}
		return b;
	}

	@Override
	public boolean insertUser(User u) {
		Connection conn;
		boolean b = true;
		try {
			conn = connect();
			PreparedStatement stmt = conn.prepareStatement(
					"INSERT INTO users (name , surname , email , phone ,nationality) VALUES (? , ? ,  ? ,  ?, ?)");

			stmt.setString(1, u.getName());
			stmt.setString(2, u.getSurname());

			stmt.setString(3, u.getEmail());
			stmt.setString(4, u.getPhone());

			stmt.setString(5, u.getNationality());

			b = stmt.execute();

		} catch (Exception ex) {
			System.err.println(ex);
			b = false;
		}
		return b;
	}

	@Override
	public boolean removeUser(int id) {
		try {
			PreparedStatement stmt = connect().prepareStatement("DELETE FROM users  WHERE ID=?;");
			stmt.setInt(1, id);
			return stmt.execute();

		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
}
