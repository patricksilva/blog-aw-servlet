package br.com.vofffice.aw.blog.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.vofffice.aw.blog.dao.UserDao;
import br.com.vofffice.aw.blog.domain.User;

public class UserDaoMysql implements UserDao {

	@Override
	public User getOne(Long id) {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        User user = null;
        
        try {
			conn = ConnectionManager.getConexao();
			prepStmt = conn.prepareStatement("SELECT * FROM user WHERE id = ?");
			prepStmt.setLong(1, id);
			rs = prepStmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getLong("id"));
				user.setFullName(rs.getString("full_name"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setCreatedAt(rs.getDate("created_at"));
				user.setUpdatedAt(rs.getDate("updated_at"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeAll(conn, prepStmt, rs);
		}
		return user;
	}

	@Override
	public List<User> findAll() {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();
        
        try {
			conn = ConnectionManager.getConexao();
			prepStmt = conn.prepareStatement("SELECT * FROM user");
			rs = prepStmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getLong("id"));
				user.setFullName(rs.getString("full_name"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setCreatedAt(rs.getDate("created_at"));
				user.setUpdatedAt(rs.getDate("updated_at"));
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeAll(conn, prepStmt, rs);
		}
		return users;
	}

	@Override
	public User save(User user) {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        String sql;
        try {
			conn = ConnectionManager.getConexao();
			
			if (user.getId() == null) {
				sql = "INSERT INTO user (full_name, username, password) VALUES (?, ?, ?)";
			} else {
				sql = "UPDATE user SET full_name = ?, username = ?, password = ?, updated_at = now() WHERE id = ?";
			}
			
			prepStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			prepStmt.setString(1, user.getFullName());
			prepStmt.setString(2, user.getUsername());
			prepStmt.setString(3, user.getPassword());
			
			if (user.getId() != null) {
				prepStmt.setLong(4, user.getId());
			}
			
			prepStmt.execute();
			
			if (user.getId() == null) {
				rs = prepStmt.getGeneratedKeys();
				if (rs.next()) {
					user.setId(rs.getLong(1));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeAll(conn, prepStmt, rs);
		}
		return user;
	}

	@Override
	public User delete(User user) {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        String sql;
        try {
			conn = ConnectionManager.getConexao();
			sql = "DELETE FROM user WHERE id = ?";
			prepStmt = conn.prepareStatement(sql);
			prepStmt.setLong(1, user.getId());

			prepStmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeAll(conn, prepStmt, rs);
		}
		return user;
	}

	@Override
	public User findByUsername(String username) {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        User user = null;
        
        try {
			conn = ConnectionManager.getConexao();
			prepStmt = conn.prepareStatement("SELECT * FROM user WHERE username = ?");
			prepStmt.setString(1, username);
			rs = prepStmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getLong("id"));
				user.setFullName(rs.getString("full_name"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setCreatedAt(rs.getDate("created_at"));
				user.setUpdatedAt(rs.getDate("updated_at"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeAll(conn, prepStmt, rs);
		}
		return user;
	}

}
