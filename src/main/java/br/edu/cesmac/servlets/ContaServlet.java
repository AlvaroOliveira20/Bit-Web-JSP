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

import br.edu.cesmac.dao.ContaDao;
import br.edu.cesmac.model.Conta;

@WebServlet(urlPatterns = {"/conta", "/conta/", "/conta/nova", "/conta/adiciona", "/conta/remove", "/conta/altera", "/conta/edita"})
public class ContaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ContaDao contaDao;

	public void init() {
		contaDao = new ContaDao();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getServletPath();

		try {
			if (acao.equals("/conta/adiciona")) {
				adiciona(request, response);
			} else if (acao.equals("/conta/altera")) {
				altera(request, response);				
			} else if (acao.equals("/conta/nova")) {
				nova(request, response);
			} else if (acao.equals("/conta/edita")) {
				edita(request, response);				
			} else if (acao.equals("/conta/remove")) {
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
		Conta conta = new Conta();
		conta.setNome(request.getParameter("nome"));
		conta.setCpf(request.getParameter("cpf"));
		conta.setEmail(request.getParameter("email"));
		conta.setSenha(request.getParameter("senha"));

		try {
			contaDao.adiciona(conta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("/conta");
	}

	private void altera(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Conta conta = new Conta();
		conta.setIdConta(Integer.parseInt(request.getParameter("id")));
		conta.setNome(request.getParameter("nome"));
		conta.setCpf(request.getParameter("cpf"));
		conta.setEmail(request.getParameter("email"));
		conta.setSenha(request.getParameter("senha"));
		contaDao.altera(conta);
		response.sendRedirect("/conta");
	}

	private void nova(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Conta conta = new Conta();
		request.setAttribute("conta", conta);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/conta/manter.jsp");	
		dispatcher.forward(request, response);	
	}
	
	private void edita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Conta conta = new Conta();
		int id = Integer.parseInt(request.getParameter("id"));

		conta = contaDao.getById(id);
        request.setAttribute("conta", conta);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/conta/manter.jsp");	
		dispatcher.forward(request, response);	
	}	

	private void remove(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Conta conta = new Conta();
		conta.setIdConta(Integer.parseInt(request.getParameter("id")));

		contaDao.remove(conta);
		response.sendRedirect("/conta");
	}

	private void lista(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List <Conta> contas = contaDao.getLista();
        request.setAttribute("contas", contas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/conta/consulta.jsp");
        dispatcher.forward(request, response);		

	}

}
