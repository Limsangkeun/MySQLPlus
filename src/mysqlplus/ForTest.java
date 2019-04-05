package mysqlplus;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ForTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection conn = DBConn.getConnection("localhost", "1521", "xe", "sky", "dla114301");
			String sql = "delete from test9 where name='kakaka'";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
