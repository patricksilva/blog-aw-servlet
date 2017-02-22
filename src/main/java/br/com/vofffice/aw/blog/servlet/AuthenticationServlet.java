package br.com.vofffice.aw.blog.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vofffice.aw.blog.dao.UserDao;
import br.com.vofffice.aw.blog.dao.mysql.UserDaoMysql;
import br.com.vofffice.aw.blog.domain.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "Authentication", urlPatterns = { "/authenticate/*" })
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Map<String, User> usuarios = new HashMap<>();

	@Override
	public void init() throws ServletException {

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDao dao = new UserDaoMysql();
		
		//busca o usuario da base de dados;
		User usuario = dao.findByUsername(username);
		
		String acao = request.getPathInfo();
		
		String context = request.getContextPath(); 
		
		System.out.println("======================");
		System.out.println("===>> context = " +context);
		System.out.println("===>> acao = " +acao);
		System.out.println("======================");
		
		if (acao.equals("/login")) {
			if (usuario != null && usuario.verifyPassword(password)) {
				request.getSession().setAttribute("usuario", usuario);
				response.sendRedirect(context + "/principal.jsp");
			} else {
				response.sendError(HttpServletResponse.SC_FORBIDDEN);
				//response.sendRedirect(context + "/login.html?erro=true");
			}
		} else { /*logout*/
			request.getSession().invalidate();
			response.sendRedirect(context + "/login.jsp");
		}
		
		
		
	}

}
