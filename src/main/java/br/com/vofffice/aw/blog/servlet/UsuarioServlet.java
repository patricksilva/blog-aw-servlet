package br.com.vofffice.aw.blog.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vofffice.aw.blog.dao.UserDao;
import br.com.vofffice.aw.blog.dao.mysql.UserDaoMysql;
import br.com.vofffice.aw.blog.domain.User;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/user/*")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final UserDao dao = new UserDaoMysql();
		
		final List<User> users = dao.findAll();
		request.setAttribute("users", users);
		
		final RequestDispatcher dispatcher = request.getRequestDispatcher("/userPages/list.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final String acao = request.getPathInfo();
		
		final UserDao dao = new UserDaoMysql();
		
		final String strId = request.getParameter("id");
		final Long id = Long.valueOf(strId);
		final User user = new User();
		String destino = null;
		List<User> users = new ArrayList<>();
		
		switch(acao) {
			case "/delete" :
				user.setId(id);
				dao.delete(user);
				
				users = dao.findAll();
				request.setAttribute("users", users);
				
				destino = "/userPages/list.jsp";
				break;
			case "/edit" :
				request.setAttribute("userToUpdate", dao.getOne(id));

				destino = "/userPages/form.jsp";
				break;
				
			case "/save" :
				//salvar o usuario
				//recupera os parametros do form
				final String fullName = request.getParameter("fullNameToSave");
				final String password = request.getParameter("passawordToSave");
				final String username = request.getParameter("usernameToSave");
				System.out.println(fullName + '#' + password + '#' + username);
				user.setFullName(fullName);
				user.setPassword(password);
				user.setUsername(username);
				dao.save(user);
				
				users = dao.findAll();
				request.setAttribute("users", users);
				
				destino = "/userPages/list.jsp";
				break;
		}
		
		final RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
		dispatcher.forward(request, response);
		
	}

}
