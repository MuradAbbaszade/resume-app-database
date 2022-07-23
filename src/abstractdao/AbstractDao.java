package abstractdao;

import java.sql.Connection;
import java.sql.DriverManager;

public class AbstractDao {
	public static Connection connect() throws Exception {
		String url = "jdbc:mysql://localhost:3306/resume";
		String username = "root";
		String password = "";
		Connection c = DriverManager.getConnection(url, username, password);
		return c;
	}
}
