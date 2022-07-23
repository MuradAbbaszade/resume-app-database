package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import abstractdao.AbstractUserSkillDao;
import entity.Skill;
import entity.UserSkill;

public class UserSkillDao extends AbstractUserSkillDao {

	@Override
	public List<UserSkill> getUserSkills(int userId) {
		List<UserSkill> list = new ArrayList<>();
		Connection conn;
		try {
			conn = connect();

			Statement stmt = conn.createStatement();
			stmt.execute("select * from user_skill where user_id=" + userId);
			ResultSet rs = stmt.getResultSet();

			while (rs.next()) {
				int id = rs.getInt("user_id");
				int skillId = rs.getInt("skill_id");
				int power = rs.getInt("power");
				UserSkill us = new UserSkill(skillId, power, id);
				list.add(us);
			}
		} catch (Exception ex) {

		}
		return list;
	}

	public String getSkillName(UserSkill us) {
		Connection conn;
		String skillName = null;
		try {
			conn = connect();

			Statement stmt = conn.createStatement();
			stmt.execute("select name from skill where id=" + us.getSkillId());
			ResultSet rs = stmt.getResultSet();
			rs.next();
			skillName = rs.getString("name");
		} catch (Exception ex) {

		}
		return skillName;
	}

	@Override
	public void addUserSkill(int userId, Skill skill, int power) {
		Connection conn;
		try {
			conn = connect();
			PreparedStatement stmt = conn.prepareStatement("Insert into user_skill Values(?,?,?)");
			stmt.setInt(1, userId);
			stmt.setInt(2, skill.getId());
			stmt.setInt(3, power);
			stmt.execute();

		} catch (Exception ex) {

		}
	}

	@Override
	public void removeUserSkills(int userId) {
		Connection conn;
		try {
			conn = connect();
			Statement stmt = conn.createStatement();
			stmt.execute("delete from user_skill where user_id=" + userId);

		} catch (Exception ex) {

		}
	}

}
