package br.edu.cesmac.servlets;
// https://www.javaguides.net/2019/03/jsp-servlet-jdbc-mysql-crud-example-tutorial.html

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.cesmac.dao.CadastroDao;
import br.edu.cesmac.model.Cadastro;

@WebServlet(urlPatterns = {"/cadastro", "/cadastro/", "/cadastro/nova", "/cadastro/adiciona", "/cadastro/remove", "/cadastro/altera", "/cadastro/edita"})
public class CadastroServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CadastroDao cadastroDao;

	public void init() {
		cadastroDao = new CadastroDao();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getServletPath();

		try {
			if (acao.equals("//adiciona")) {
				adiciona(request, response);
			} else if (acao.equals("/cadastro/altera")) {
				altera(request, response);				
			} else if (acao.equals("/cadastro/nova")) {
				nova(request, response);
			} else if (acao.equals("/cadastro/edita")) {
				edita(request, response);				
			} else if (acao.equals("/cadastro/remove")) {
				remove(request, response);
			} else {
				lista(request, response);
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void adiciona(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Cadastro cadastro = new Cadastro();
		cadastro.setNome(request.getParameter("nome"));

		try {
			cadastroDao.adiciona(cadastro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("/cadastro");
	}

	private void altera(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Cadastro cadastro = new Cadastro();
		cadastro.setIdCadastro(Integer.parseInt(request.getParameter("id")));
		cadastro.setNome(request.getParameter("nome"));
		cadastro.setCpf(request.getParameter("cpf"));
		cadastro.setEmail(request.getParameter("email"));
		cadastro.setSenha(request.getParameter("senha"));
		cadastroDao.altera(cadastro);
		response.sendRedirect("/cadastro");
	}

	private void nova(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cadastro cadastro = new Cadastro();
		request.setAttribute("cadastro", cadastro);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastro/manter.jsp");	
		dispatcher.forward(request, response);	
	}
	
	private void edita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cadastro cadastro = new Cadastro();
		int id = Integer.parseInt(request.getParameter("id"));

		cadastro = cadastroDao.getById(id);
        request.setAttribute("cadastro", cadastro);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastro/manter.jsp");	
		dispatcher.forward(request, response);	
	}	

	private void remove(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Cadastro cadastro = new Cadastro();
		cadastro.setIdCadastro(Integer.parseInt(request.getParameter("id")));

		cadastroDao.remove(cadastro);
		response.sendRedirect("/cadastro");
	}

	private void lista(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List <Cadastro> cadastros = cadastroDao.getLista();
        request.setAttribute("cadastros", cadastros);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastro/consulta.jsp");
        dispatcher.forward(request, response);		

	}

}
