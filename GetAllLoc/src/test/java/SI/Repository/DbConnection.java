package SI.Repository;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class DbConnection {


	static String JDBC_Driver = "com.mysql.jdbc.Driver";
	// JDBC driver name and database URL  
		//static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://localhost:3306/deepika"+"?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true";

		//	static final String DB_URL = "jdbc:mysql://localhost:3306/deepika"+"?autoReconnect=true&useSSL=false";

		// Database credentials
		static final String USER = "root";
		static final String PASS = "Deepika@123";
	static Connection conn = null;
	static Statement stmt = null;
	static LocalDateTime date = LocalDateTime.now();
	static LocalDateTime Previousdate = LocalDateTime.now().minusDays(1);

	public void database(String client_name, String urls) throws ClassNotFoundException {

		System.out.println(date);
		try {
			Class.forName(JDBC_DRIVER);

			try {
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				stmt = conn.createStatement();

				String sql = "insert into deepika.silocation (client_name,urls,date) values ('"
						+ client_name+ "','" + urls +"','"  + date + "')";

				stmt.executeUpdate(sql);
				conn.close();
				stmt.close();
			} catch (SQLException ex) {
				stmt.close();
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

}

