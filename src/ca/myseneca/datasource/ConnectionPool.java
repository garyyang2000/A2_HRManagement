package ca.myseneca.datasource;

import java.sql.*;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * ConnectionPool class contains JDBC connection(two defined for MySQL and
 * Oracle separately, but only oracle is implemented here) that are created when
 * it is registered to Tomcat or other target server. It's implemented with
 * singleton pattern with method to get connection and free connection
 * 
 * @version:1.0
 * @date: April 10, 2016
 * @author: Ge Yang, Yan Liu, Bohao Liu
 */
public class ConnectionPool {

	private static ConnectionPool pool = null;
	private static DataSource dataSource = null;

	private ConnectionPool() {
		try {
			InitialContext ic = new InitialContext();
			dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/oracle_cjv805_161a19");
			;
		} catch (NamingException e) {
			System.out.println("Error in construct:" + e);
		}
	}

	public static synchronized ConnectionPool getInstance() {
		if (pool == null) {
			pool = new ConnectionPool();
		}
		return pool;
	}

	public Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			System.out.println("Error in get connection :" + e);
			return null;
		}
	}

	public void freeConnection(Connection c) {
		try {
			c.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}