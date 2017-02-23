package br.com.vofffice.aw.blog.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.vofffice.aw.blog.dao.BlogPostDao;
import br.com.vofffice.aw.blog.dao.UserDao;
import br.com.vofffice.aw.blog.domain.BlogPost;
import br.com.vofffice.aw.blog.domain.User;

public class BlogPostDaoMysql implements BlogPostDao {

	@Override
	public BlogPost getOne(final Long id) {
		Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        BlogPost blogPost = null;
        
        
        try {
			conn = ConnectionManager.getConexao();
			prepStmt = conn.prepareStatement("SELECT * FROM blog_post WHERE id = ?");
			prepStmt.setLong(1, id);
			rs = prepStmt.executeQuery();
			
			if (rs.next()) {
				
				blogPost = new BlogPost();
				
				final UserDao 	userDao = new UserDaoMysql();
				final User 		user 	= userDao.getOne(rs.getLong("user_id"));
				
				blogPost.setId(rs.getLong("id"));
				blogPost.setTitle(rs.getString("title"));
				blogPost.setText(rs.getString("text"));
				blogPost.setUser(user);
				blogPost.setCreatedAt(rs.getDate("created_at"));
				blogPost.setUpdatedAt(rs.getDate("updated_at"));
			}
		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeAll(conn, prepStmt, rs);
		}
		return blogPost;
	}

	@Override
	public List<BlogPost> findAll() {
		Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        final List<BlogPost> blogPosts = new ArrayList<>();
        
        try {
			conn = ConnectionManager.getConexao();
			prepStmt = conn.prepareStatement("SELECT bp.* FROM blog_post bp inner join user u on bp.user_id=u.id");
			rs = prepStmt.executeQuery();
			
			while (rs.next()) {
				
				final BlogPost blogPost = new BlogPost();
				
				final UserDao 	userDao = new UserDaoMysql();
				final User 		user 	= userDao.getOne(rs.getLong("user_id"));
				
				blogPost.setId(rs.getLong("id"));
				blogPost.setTitle(rs.getString("title"));
				blogPost.setText(rs.getString("text"));
				blogPost.setUser(user);
				blogPost.setCreatedAt(rs.getDate("created_at"));
				blogPost.setUpdatedAt(rs.getDate("updated_at"));
				
			}
		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeAll(conn, prepStmt, rs);
		}
		return blogPosts;
	}

	@Override
	public BlogPost save(final BlogPost blogPost) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlogPost delete(final BlogPost blogPost) {
		// TODO Auto-generated method stub
		return null;
	}

}
