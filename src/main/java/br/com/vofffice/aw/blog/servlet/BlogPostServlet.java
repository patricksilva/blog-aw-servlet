package br.com.vofffice.aw.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vofffice.aw.blog.dao.BlogPostDao;
import br.com.vofffice.aw.blog.dao.mysql.BlogPostDaoMysql;
import br.com.vofffice.aw.blog.domain.BlogPost;

/**
 * Servlet implementation class BlogPostServlet
 */
@WebServlet("/BlogPostServlet/*")
public class BlogPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		
		final BlogPostDao blogPostDao = new BlogPostDaoMysql();
		
		final List<BlogPost> blogPosts = blogPostDao.findAll();
		request.setAttribute("blogPosts", blogPosts);
		
		final RequestDispatcher dispatcher = request.getRequestDispatcher("/blogPages/list.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
