package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import abstractdao.AbstractEmploymentDao;
import entity.Employment;

public class EmploymentDao extends AbstractEmploymentDao {

	@Override
	public List<Employment> getAll() {
		List<Employment> list = new ArrayList<>();
		Connection conn;
		try {
			conn = connect();

			Statement stmt = conn.createStatement();
			stmt.execute("SELECT * FROM employment");
			ResultSet rs = stmt.getResultSet();

			while (rs.next()) {
				int userId = rs.getInt("user_id");
				String jobDescription = rs.getString("job_description");
				Date beginDate = rs.getDate("begin_date");
				Date endDate = rs.getDate("end_date");
				Employment e = new Employment(userId, jobDescription, beginDate, endDate);
				list.add(e);
			}
		} catch (Exception ex) {

		}
		return list;
	}

	@Override
	public boolean updateUserEmployment(Employment e) {
		Connection conn;
		boolean update = true;
		try {
			conn = connect();

			PreparedStatement stmt = conn.prepareStatement(
					"UPDATE employment SET job_description=? , begin_date=? , end_date = ? WHERE user_id= ?;");
			stmt.setString(1, e.getJobDescription());
			stmt.setDate(2, e.getBeginDate());
			stmt.setDate(3, e.getEndDate());
			stmt.setInt(4, e.getId());
			update = stmt.execute();
		} catch (Exception ex) {
		}
		return update;
	}

	@Override
	public List<Employment> getUserEmployment(int userId) {
		List<Employment> list = new ArrayList<Employment>();
		Connection conn;
		try {
			conn = connect();
			Statement stmt = conn.createStatement();
			stmt.execute("SELECT * FROM employment");
			ResultSet rs = stmt.getResultSet();
			while (rs.next()) {
				String jobDescription = rs.getString("job_description");
				Date beginDate = rs.getDate("begin_date");
				Date endDate = rs.getDate("end_date");
				Employment e = new Employment(userId, jobDescription, beginDate, endDate);
				list.add(e);
			}
		} catch (Exception ex) {

		}
		return list;
	}

	@Override
	public void addUserEmployment(Employment e) {
		Connection conn;
		try {
			conn = connect();

			PreparedStatement stmt = conn.prepareStatement("Insert into employment VALUES(?,?,?,?) ");
			stmt.setInt(1, e.getId());
			stmt.setString(2, e.getJobDescription());
			stmt.setDate(3, e.getBeginDate());
			stmt.setDate(4, e.getEndDate());
			stmt.execute();
		} catch (Exception ex) {
		}
	}

	@Override
	public void removeUserEmployments(int userId) {
		Connection conn;
		try {
			conn = connect();

			PreparedStatement stmt = conn.prepareStatement("Delete from employment where user_id=? ");
			stmt.setInt(1, userId);
			stmt.execute();
		} catch (Exception ex) {
		}
	}

}
