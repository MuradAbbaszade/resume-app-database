package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import abstractdao.AbstractSkillDao;
import entity.Skill;

public class SkillDao extends AbstractSkillDao {
	@Override
	public List<Skill> getAll() {
		List<Skill> list = new ArrayList<>();
		Connection conn;
		try {
			conn = connect();
			Statement stmt = conn.createStatement();
			stmt.execute("SELECT * FROM skill");
			ResultSet rs = stmt.getResultSet();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Skill s = new Skill(id, name);
				list.add(s);
			}
		} catch (Exception ex) {

		}
		return list;
	}
}
