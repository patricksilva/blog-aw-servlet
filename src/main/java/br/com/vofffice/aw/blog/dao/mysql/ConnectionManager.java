package br.com.vofffice.aw.blog.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionManager {

	private static final String STR_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DATABASE = "blog-aw";
	private static final String IP = "localhost";
	private static final String STR_CON = "jdbc:mysql://" + IP + ":3306/" + DATABASE;
	private static final String USER = "aw";
	private static final String PASSWORD = "aw";

	public static Connection getConexao() throws Exception {
		Connection conn = null;
		Class.forName(STR_DRIVER);
		conn = DriverManager.getConnection(STR_CON, USER, PASSWORD);
		System.out.println("[ConnectionManager]: Obtendo conexao");
		return conn;
	}

	public static void closeAll(final Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeAll(final Connection conn, final Statement stmt, final ResultSet rs) {
		try {
			if (conn != null || stmt != null) {
				closeAll(conn, stmt);
			}
			if (rs != null) {
				rs.close();
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeAll(final Connection conn, final Statement stmt) {
		try {
			if (conn != null) {
				closeAll(conn);
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
