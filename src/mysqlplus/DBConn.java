package mysqlplus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private static Connection instance;
	
	public static Connection getConnection(String ip, String port, String sid, String user, String pw) throws SQLException {
		
		if(instance == null) {
			String url = "jdbc:oracle:thin:@"+ip+":"+port+":"+sid;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			instance = DriverManager.getConnection(url, user, pw);
		}
		return instance;
	}
	
	public static void close() {
		if(instance != null) {
			try {
				if(!instance.isClosed()) {
					instance.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
