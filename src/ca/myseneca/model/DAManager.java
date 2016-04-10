/**
* The DAManager class implements all methods  that can
* be used to operate employees table. It provides static 
* methods to get employee, department, employees and 
* other useful function.
* 
* 
* @author  Ge Yang, Bohao Liu, Yan Liu
* @version 2.0
* @since   2016-04-10 
*/
package ca.myseneca.model;

import java.sql.*;
import java.util.ArrayList;
import ca.myseneca.datasource.ConnectionPool;
import java.math.BigDecimal;
import oracle.jdbc.*;

public class DAManager {

	public static int getEmployeeID(String user, String password) {
		int result = -1;
		CallableStatement stmt = null;
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection conn = pool.getConnection();

		try {

			stmt = conn.prepareCall("{?=call P_SECURITY.F_SECURITY(?,?)}");
			stmt.setInt(1, result);
			stmt.setString(2, user);
			stmt.setString(3, password);
			stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
			stmt.executeQuery();
			result = stmt.getInt(1);
			SQLWarning w = stmt.getWarnings();
			DBUtil.printWarnings(w);

		} catch (BatchUpdateException batchEx) {
			DBUtil.printBatchUpdateException(batchEx);
		} catch (SQLException sqlEx) {
			DBUtil.printSQLException(sqlEx);

		} catch (Exception ex) {
			System.err.println("Failed to get :" + ex.toString());
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					DBUtil.printSQLException(e);
				}
			}
			//
			pool.freeConnection(conn);
			/*
			 * if (conn != null) { try { conn.close(); } catch (SQLException e)
			 * { DBUtil.printSQLException(e); } }
			 */
		}
		return result;
	}

	public static boolean addEmployee(Employee emp) {
		boolean result = false;
		PreparedStatement pstmt = null;
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection conn = pool.getConnection();
		try {
			String sql = "INSERT INTO EMPLOYEES " + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmployeeId());
			String fname = emp.getFirstName();
			if (fname != null) {
				pstmt.setString(2, fname);
			} else {
				pstmt.setNull(2, OracleTypes.NULL);
			}

			pstmt.setString(3, emp.getLastName());
			pstmt.setString(4, emp.getEmail());

			pstmt.setString(5, emp.getPhoneNumber());
			pstmt.setDate(6, emp.getHireDate());
			pstmt.setString(7, emp.getJobId());
			pstmt.setBigDecimal(8, emp.getSalary());
			pstmt.setBigDecimal(9, emp.getCommissionPct());
			pstmt.setInt(10, emp.getManagerId());
			pstmt.setInt(11, emp.getDepartmentId());

			pstmt.executeUpdate();
			SQLWarning w = pstmt.getWarnings();
			DBUtil.printWarnings(w);
			result = true;

		} catch (BatchUpdateException batchEx) {
			DBUtil.printBatchUpdateException(batchEx);
			result = false;
		} catch (SQLException sqlEx) {
			DBUtil.printSQLException(sqlEx);
			result = false;
		} catch (Exception ex) {
			result = false;
			System.err.println("Failed to add employee :" + ex.toString());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					DBUtil.printSQLException(e);
				}
			}
			pool.freeConnection(conn);
			/*
			 * if (conn != null) { try { conn.close(); } catch (SQLException e)
			 * { DBUtil.printSQLException(e); } }
			 */
		}
		return result;
	}

	public static ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> allEmps = new ArrayList<Employee>();
		Statement stmt = null;
		ResultSet rset = null;
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection conn = pool.getConnection();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM EMPLOYEES";
			stmt.execute(sql);
			SQLWarning w = stmt.getWarnings();
			DBUtil.printWarnings(w);
			rset = stmt.getResultSet();
			while (rset.next()) {
				int empId = rset.getInt(1);
				String fName = rset.getString(2);
				String lName = rset.getString(3);
				String email = rset.getString(4);
				String phone = rset.getString(5);
				Date hrDate = rset.getDate(6);
				String jobID = rset.getString(7);
				BigDecimal sal = rset.getBigDecimal(8);
				BigDecimal commiPct = rset.getBigDecimal(9);
				int mgrID = rset.getInt(10);
				int deptID = rset.getInt(11);
				String deptName = "";
				Employee newEmp = new Employee(empId, fName, lName, email, phone, hrDate, jobID, sal, commiPct, mgrID,
						deptID, deptName);
				allEmps.add(newEmp);
			}

		} catch (BatchUpdateException batchEx) {
			DBUtil.printBatchUpdateException(batchEx);
		} catch (SQLException sqlEx) {
			DBUtil.printSQLException(sqlEx);

		} catch (Exception ex) {
			System.err.println("Failed to add employee :" + ex.toString());
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					DBUtil.printSQLException(e);
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					DBUtil.printSQLException(e);
				}
			}
			pool.freeConnection(conn);

		}
		return allEmps;
	}

	public static ArrayList<Employee> getEmployeesByDepartmentID(int depid) {
		ArrayList<Employee> allEmps = new ArrayList<Employee>();
		Statement stmt = null;
		ResultSet rset = null;
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection conn = pool.getConnection();
		try {
			stmt = conn.createStatement();
			String deptName = "";
			String sql = "SELECT DEPARTMENT_NAME FROM DEPARTMENTS WHERE DEPARTMENT_ID=" + depid;
			stmt.executeUpdate(sql);
			rset = stmt.getResultSet();
			while (rset.next()) {
				deptName = rset.getString(1);
			}
			rset.close();
			sql = "SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID=" + depid;
			stmt.executeUpdate(sql);
			SQLWarning w = stmt.getWarnings();
			DBUtil.printWarnings(w);
			rset = stmt.getResultSet();
			while (rset.next()) {
				int empId = rset.getInt(1);
				String fName = rset.getString(2);
				String lName = rset.getString(3);
				String email = rset.getString(4);
				String phone = rset.getString(5);
				Date hrDate = rset.getDate(6);
				String jobID = rset.getString(7);
				BigDecimal sal = rset.getBigDecimal(8);
				BigDecimal commiPct = rset.getBigDecimal(9);
				int mgrID = rset.getInt(10);
				int deptID = rset.getInt(11);
				Employee newEmp = new Employee(empId, fName, lName, email, phone, hrDate, jobID, sal, commiPct, mgrID,
						deptID, deptName);
				allEmps.add(newEmp);

			}

		} catch (BatchUpdateException batchEx) {
			DBUtil.printBatchUpdateException(batchEx);
		} catch (SQLException sqlEx) {
			DBUtil.printSQLException(sqlEx);
		} catch (Exception ex) {
			System.err.println("Failed to add employee :" + ex.toString());
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					DBUtil.printSQLException(e);
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					DBUtil.printSQLException(e);
				}
			}
			pool.freeConnection(conn);

		}
		return allEmps;
	}

	public static ArrayList<Department> getAllDepartments() {
		ArrayList<Department> allDepts = new ArrayList<Department>();
		Statement stmt = null;
		ResultSet rset = null;
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection conn = pool.getConnection();
		try {
			stmt = conn.createStatement();
			String deptName = "";
			String sql = "SELECT DEPARTMENT_ID,DEPARTMENT_NAME FROM DEPARTMENTS";
			stmt.executeUpdate(sql);
			rset = stmt.getResultSet();
			while (rset.next()) {
				int deptId = rset.getInt(1);
				deptName = rset.getString(2);
				Department dept = new Department(deptId, deptName);
				allDepts.add(dept);
			}

		} catch (BatchUpdateException batchEx) {
			DBUtil.printBatchUpdateException(batchEx);
		} catch (SQLException sqlEx) {
			DBUtil.printSQLException(sqlEx);
		} catch (Exception ex) {
			System.err.println("Failed to add employee :" + ex.toString());
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					DBUtil.printSQLException(e);
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					DBUtil.printSQLException(e);
				}
			}
			pool.freeConnection(conn);

		}
		return allDepts;
	}

	public static Employee getEmployeeByID(int empid) {
		Employee newEmp = null;
		OracleConnection oracleConnection = null;
		OracleCallableStatement ostmt = null;
		ResultSet rset = null;
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection conn = pool.getConnection();
		try {
			if (conn == null) {
				conn = ConnectionPool.getInstance().getConnection();
			}
			if (conn.isWrapperFor(OracleConnection.class)) {
				oracleConnection = conn.unwrap(OracleConnection.class);
			} else {
				oracleConnection = (OracleConnection) conn;
			}
			ostmt = (OracleCallableStatement) oracleConnection.prepareCall("{call P_SECURITY.P_EMP_INFO(?,?)}");
			ostmt.setInt(1, empid);
			ostmt.registerOutParameter(2, OracleTypes.CURSOR);
			ostmt.execute();
			SQLWarning w = ostmt.getWarnings();
			DBUtil.printWarnings(w);
			rset = (OracleResultSet) ostmt.getCursor(2);
			if (rset.next()) {
				int empId = rset.getInt(1);
				String fName = rset.getString(2);
				String lName = rset.getString(3);
				String email = rset.getString(4);
				String phone = rset.getString(5);
				Date hrDate = rset.getDate(6);
				String jobID = rset.getString(7);
				BigDecimal sal = rset.getBigDecimal(8);
				BigDecimal commiPct = rset.getBigDecimal(9);
				int mgrID = rset.getInt(10);
				int deptID = rset.getInt(11);
				String deptName = "";
				newEmp = new Employee(empId, fName, lName, email, phone, hrDate, jobID, sal, commiPct, mgrID, deptID,
						deptName);
			}

		} catch (BatchUpdateException batchEx) {
			DBUtil.printBatchUpdateException(batchEx);
		} catch (SQLException sqlEx) {
			DBUtil.printSQLException(sqlEx);

		} catch (Exception ex) {
			System.err.println("Failed to add employee :" + ex.toString());
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					DBUtil.printSQLException(e);
				}
			}
			if (ostmt != null) {
				try {
					ostmt.close();
				} catch (SQLException e) {
					DBUtil.printSQLException(e);
				}
			}
			pool.freeConnection(conn);

		}
		return newEmp;
	}

	public static int updateEmployee(Employee emp) {
		int result = -1;
		ResultSet uprs = null;
		PreparedStatement pstmt = null;
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection conn = pool.getConnection();
		try {

			String sql = "SELECT EMPLOYEE_ID, FIRST_NAME,LAST_NAME, EMAIL,PHONE_NUMBER,HIRE_DATE, JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID   FROM EMPLOYEES WHERE EMPLOYEE_ID= ?";
			pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setInt(1, emp.getEmployeeId()); // set input values

			uprs = pstmt.executeQuery();
			if (uprs.next()) {
				uprs.updateString("FIRST_NAME", emp.getFirstName());
				uprs.updateString("LAST_NAME", emp.getLastName());
				uprs.updateString("EMAIL", emp.getEmail());
				uprs.updateString("PHONE_NUMBER", emp.getPhoneNumber());
				uprs.updateDate("HIRE_DATE", emp.getHireDate());
				uprs.updateString("JOB_ID", emp.getJobId());
				uprs.updateBigDecimal("SALARY", emp.getSalary());
				uprs.updateBigDecimal("COMMISSION_PCT", emp.getCommissionPct());
				uprs.updateInt("MANAGER_ID", emp.getManagerId());
				uprs.updateInt("DEPARTMENT_ID", emp.getDepartmentId());
				uprs.updateRow();
				result = 1;
			}
			SQLWarning w = pstmt.getWarnings();
			DBUtil.printWarnings(w);

		} catch (Exception ex) {
			System.err.println("Failed to add employee :" + ex.toString());
		} finally {
			if (uprs != null) {
				try {
					uprs.close();
				} catch (SQLException e) {
					DBUtil.printSQLException(e);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					DBUtil.printSQLException(e);
				}
			}
			pool.freeConnection(conn);

		}
		return result;
	}

	public static int deleteEmployeeByID(int empid) {
		int result = -1;
		Statement stmt = null;
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection conn = pool.getConnection();
		try {

			String sql = "DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID=" + empid;
			stmt = conn.createStatement();

			result = stmt.executeUpdate(sql);
			SQLWarning w = stmt.getWarnings();
			DBUtil.printWarnings(w);

		} catch (BatchUpdateException batchEx) {
			DBUtil.printBatchUpdateException(batchEx);
		} catch (SQLException sqlEx) {
			DBUtil.printSQLException(sqlEx);

		} catch (Exception ex) {
			System.err.println("Failed to add employee :" + ex.toString());
		} finally {

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					DBUtil.printSQLException(e);
				}
			}
			pool.freeConnection(conn);
			/*
			 * if (conn != null) { try { conn.close(); } catch (SQLException e)
			 * { DBUtil.printSQLException(e); } }
			 */
		}
		return result;
	}

	public static ArrayList<Employee> searchEmployee(String keyword) {
		ArrayList<Employee> allEmps = new ArrayList<Employee>();
		PreparedStatement stmt = null;
		ResultSet rset = null;
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection conn = pool.getConnection();
		try {

			String sql = "Select e.EMPLOYEE_ID, e.FIRST_NAME, e.LAST_NAME, e.EMAIL,"
					+ " e.PHONE_NUMBER, e.HIRE_DATE , e.JOB_ID , e.SALARY, "
					+ "e.COMMISSION_PCT,  e.MANAGER_ID    , e.DEPARTMENT_ID,d.DEPARTMENT_NAME "
					+ "FROM  EMPLOYEES  e INNER JOIN DEPARTMENTS  d ON (e.department_id=d.department_id)"
					+ "WHERE e.DEPARTMENT_ID LIKE ? " + "OR e.FIRST_NAME LIKE ? OR e.LAST_NAME LIKE ?"
					+ " OR e.PHONE_NUMBER LIKE ? OR e.EMAIL LIKE ?";
			stmt = conn.prepareStatement(sql);
			keyword = "%" + keyword.toLowerCase() + "%";
			stmt.setString(1, keyword);
			stmt.setString(2, keyword);
			stmt.setString(3, keyword);
			stmt.setString(4, keyword);
			stmt.setString(5, keyword);
			stmt.executeQuery();
			SQLWarning w = stmt.getWarnings();
			DBUtil.printWarnings(w);
			rset = stmt.getResultSet();
			while (rset.next()) {
				int empId = rset.getInt(1);
				String fName = rset.getString(2);
				String lName = rset.getString(3);
				String email = rset.getString(4);
				String phone = rset.getString(5);
				Date hrDate = rset.getDate(6);
				String jobID = rset.getString(7);
				BigDecimal sal = rset.getBigDecimal(8);
				BigDecimal commiPct = rset.getBigDecimal(9);

				int mgrID = rset.getInt(10);
				int deptID = rset.getInt(11);
				String deptName = rset.getString(12);
				Employee newEmp = new Employee(empId, fName, lName, email, phone, hrDate, jobID, sal, commiPct, mgrID,
						deptID, deptName);
				allEmps.add(newEmp);

			}

		} catch (BatchUpdateException batchEx) {
			DBUtil.printBatchUpdateException(batchEx);
		} catch (SQLException sqlEx) {
			DBUtil.printSQLException(sqlEx);
		} catch (Exception ex) {
			System.err.println("Failed to add employee :" + ex.toString());
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					DBUtil.printSQLException(e);
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					DBUtil.printSQLException(e);
				}
			}
			pool.freeConnection(conn);
			/*
			 * if (conn != null) { try { conn.close(); } catch (SQLException e)
			 * { DBUtil.printSQLException(e); } }
			 */
		}
		return allEmps;
	}

	public static boolean batchUpdate(String[] SQLs) {
		boolean result = false;
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection conn = pool.getConnection();
		Statement stmt = null;
		try {

			conn.setAutoCommit(false);
			Savepoint savPnt = conn.setSavepoint("savpnt1");
			stmt = conn.createStatement();
			for (int i = 0; i < SQLs.length; i++) {
				stmt.addBatch(SQLs[i]);
			}
			int[] count = stmt.executeBatch();
			if (count.length == SQLs.length) {
				conn.commit();
			} else {
				conn.rollback(savPnt);
			}
			SQLWarning w = stmt.getWarnings();
			DBUtil.printWarnings(w);

		} catch (BatchUpdateException batchEx) {
			DBUtil.printBatchUpdateException(batchEx);
		} catch (SQLException sqlEx) {
			DBUtil.printSQLException(sqlEx);

		} catch (Exception ex) {
			System.err.println("Failed to add employee :" + ex.toString());
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					DBUtil.printSQLException(e);
				}
			}
			pool.freeConnection(conn);
			/*
			 * if (conn != null) { try { conn.close(); } catch (SQLException e)
			 * { DBUtil.printSQLException(e); } }
			 */
		}
		return result;
	}

}
