import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_JDBC {

	 public static void main(String[] args) {
		 Connection conn = null;
		 try {
			String hostUrl = "jdbc:mysql://localhost:3306/payroll_services";
			String userName = "root";
			String password = "mymaths009!@A";

			conn = DriverManager.getConnection(hostUrl, userName, password);

			if (conn != null) {
				System.out.println("Connection is made.!");
			}
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}

	}

}

