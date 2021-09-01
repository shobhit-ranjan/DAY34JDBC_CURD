import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection_JDBC {

	public static void main(String[] args) {
		getsqlConnection();
		// readEmployeePayroll();
		writeempData();

	}

	private static void readEmployeePayroll() {
		System.out.println("Displaying all data of employee_payroll table");
		Connection conn = getsqlConnection();

		try {
			if (conn != null) {
				String readEmpPayroll = "SELECT * FROM employee_payrollday34";

				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(readEmpPayroll);
				while (resultSet.next()) {
					Integer id = resultSet.getInt(1);
					String name = resultSet.getString(2);
					Integer salary = resultSet.getInt(3);
					String date = resultSet.getString(4);
					String sal = resultSet.getString(4);
					String row = String.format(
							"User record: \n Id: %d, \n Name: %s,\n Salary: %d, \n Date: %s, \n Sal: %s ", id, name,
							salary, date, sal);
					System.out.println(row);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqlException) {
					System.out.println(sqlException.getMessage());

				}
			}
		}

	}


	private static void writeempData() {
		Connection conn = getsqlConnection();
		try {

			if (conn != null) {
				String sqlInsert = "INSERT INTO employee_payrollday34 (empid ,empname ,empsalary, dateofjoin ,gender) values (?,?,?,?,?)";
				PreparedStatement connecting = conn.prepareStatement(sqlInsert);
				connecting.setInt(1, 001);
				connecting.setString(2, "Shobhit");
				connecting.setInt(3, 5000);
				connecting.setString(4, "01-01-2015");
				connecting.setString(5, "Male");

				int rowInserted = connecting.executeUpdate();
				if (rowInserted > 0) {
					System.out.println("data is added !");
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

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
	private static Connection getsqlConnection() {
		Connection conn = null;
		String hostUrl = "jdbc:mysql://localhost:3306/payroll_services";
		String userName = "root";
		String password = "mymaths00";
		try {
			conn = DriverManager.getConnection(hostUrl, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return conn;

	}


}
