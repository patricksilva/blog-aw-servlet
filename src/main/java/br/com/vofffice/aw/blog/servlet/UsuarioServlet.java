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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao dao = new UserDaoMysql();
		
		List<User> users = dao.findAll();
		request.setAttribute("users", users);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/userPages/list.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getPathInfo();
		
		UserDao dao = new UserDaoMysql();
		
		String strId = request.getParameter("id");
		Long id = Long.valueOf(strId);
		User user = new User();
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

				destino = "/userPages/form.jsp";
				break;
				
			case "/save" :
				//salvar o usuario
				//recupera os parametros do form
				
				users = dao.findAll();
				request.setAttribute("users", users);
				
				destino = "/userPages/list.jsp";
				break;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
		dispatcher.forward(request, response);
		
	}

}
