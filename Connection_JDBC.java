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
		// writeempData();
		// updateEmployeePay();
		showPAyRollBYEMPNAME();

	}

	private static void readEmployeePayroll() {
		System.out.println("Displaying all data of employee_payroll table");
		Connection conn = getsqlConnection();

		try {
			if (conn != null) {
				String readEmpPayroll = "SELECT * FROM employee_payroll";

				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(readEmpPayroll);
				while (resultSet.next()) {
					Integer id = resultSet.getInt(1);
					String name = resultSet.getString(2);
					Integer salary = resultSet.getInt(3);
					String date = resultSet.getString(4);
					String row = String.format("User record: \n Id: %d, \n Name: %s,\n Salary: %d, \n", id, name,
							salary, date);
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
				connecting.setString(2, "JKM");
				connecting.setInt(3, 9868);
				connecting.setString(4, "30-12-2018");
				connecting.setString(5, "Female");

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

	private static void updateEmployeePay() {
		System.out.println("we have update / change the salary of shobhit");
		Connection conn = getsqlConnection();
		if (conn != null) {
			String updateEmpPayroll = "UPDATE employee_payrollday34 SET empsalary = ? WHERE empname ='JKM'";
			try {
				PreparedStatement preparedStatement = conn.prepareStatement(updateEmpPayroll);
				preparedStatement.setInt(1, 22050);
				int rowUpdated = preparedStatement.executeUpdate();
				if (rowUpdated > 0) {
					System.out.println("Updated !!");
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

	}

	private static void showPAyRollBYEMPNAME() {
		System.out.println("Displaying PayRoll data by  name");
		Connection conn = getsqlConnection();

		try {
			if (conn != null) {

				String readEmpPayroll = "SELECT * FROM employee_payroll WHERE empname ='Ram Singh'";

				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(readEmpPayroll);
				while (resultSet.next()) {
					Integer id = resultSet.getInt(1);
					String name = resultSet.getString(2);
					Integer salary = resultSet.getInt(3);
					String date = resultSet.getString(4);
					String gender = resultSet.getString(5);
					String row = String.format(
							"User record: \n Id: %d, \n Name: %s,\n Salary: %d, \n Date: %s,  \n Gender: %s \n", id,
							name, salary, date, gender);
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

	private static Connection getsqlConnection() {
		Connection conn = null;
		String hostUrl = "jdbc:mysql://localhost:3306/emp_payroll";
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
