package br.com.vofffice.aw.blog.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vofffice.aw.blog.domain.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "Authentication", urlPatterns = { "/authenticate/*" })
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Map<String, Usuario> usuarios = new HashMap<>();

	@Override
	public void init() throws ServletException {
		usuarios.put("maria", new Usuario("Maria da Silva", "maria", "123"));
		usuarios.put("jose", new Usuario("Jose de Cunha", "jose", "123"));
		usuarios.put("ana", new Usuario("Ana dos Husself", "ana", "123"));
		usuarios.put("joaquim", new Usuario("Joaquim Batista", "joaquim", "123"));
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
		
		//busca o usuario da base de dados;
		Usuario usuario = usuarios.get(username);
		
		String acao = request.getPathInfo();
		
		String context = request.getContextPath(); 
		
		if (acao.equals("/login")) {
			if (usuario != null && usuario.validaPassword(password)) {
				request.getSession().setAttribute("usuario", usuario);
				response.sendRedirect(context + "/principal.jsp");
			} else {
				response.sendError(HttpServletResponse.SC_FORBIDDEN);
				//response.sendRedirect(context + "/login.html?erro=true");
			}
		} else { /*logout*/
			request.getSession().invalidate();
			response.sendRedirect(context + "/login.html");
		}
		
		
		
	}

}
