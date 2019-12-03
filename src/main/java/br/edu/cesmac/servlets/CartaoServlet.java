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

import br.edu.cesmac.dao.CartaoDao;
import br.edu.cesmac.dao.ContaDao;
import br.edu.cesmac.model.Cartao;
import br.edu.cesmac.model.Conta;

@WebServlet(urlPatterns = {"/cartao", "/cartao/", "/cartao/nova", "/cartao/adiciona", "/cartao/remove", "/cartao/altera", "/cartao/edita"})
public class CartaoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CartaoDao cartaoDao;

	public void init() {
		cartaoDao = new CartaoDao();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getServletPath();

		try {
			if (acao.equals("/cartao/adiciona")) {
				adiciona(request, response);
			} else if (acao.equals("/cartao/altera")) {
				altera(request, response);				
			} else if (acao.equals("/cartao/nova")) {
				nova(request, response);
			} else if (acao.equals("/cartao/edita")) {
				edita(request, response);				
			} else if (acao.equals("/cartao/remove")) {
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
		Cartao cartao = new Cartao();
		cartao.setCpf(request.getParameter("cpf"));
		cartao.setDataNasc(Integer.parseInt(request.getParameter("datanascimento")));
		cartao.setTelefone(request.getParameter("telefone"));
		cartao.setRg(request.getParameter("rg"));
		cartao.setOrgExped(request.getParameter("orgaoexpedidor"));
		cartao.setEndereco(request.getParameter("endereco"));
		cartao.setNumero(request.getParameter("numero"));
		cartao.setBairro(request.getParameter("bairro"));
		cartao.setComplemento(request.getParameter("complemento"));
		cartao.setCep(request.getParameter("cep"));
		cartao.setRendimento(Float.parseFloat(request.getParameter("rendimentomensal")));
		cartao.setSenhaC(Integer.parseInt(request.getParameter("senhacartao")));
		cartao.setDataVenc(Integer.parseInt(request.getParameter("datavencimento")));
		cartao.setLimite(Float.parseFloat(request.getParameter("limite")));
		cartao.setSaldo(Float.parseFloat(request.getParameter("saldo")));

		try {
			cartaoDao.adiciona(cartao);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("/cartao");
	}

	private void altera(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Cartao cartao = new Cartao();
		cartao.setId(Integer.parseInt(request.getParameter("id")));
		cartao.setCpf(request.getParameter("cpf"));
		cartao.setDataNasc(Integer.parseInt(request.getParameter("datanascimento")));
		cartao.setTelefone(request.getParameter("telefone"));
		cartao.setRg(request.getParameter("rg"));
		cartao.setOrgExped(request.getParameter("orgaoexpedidor"));
		cartao.setEndereco(request.getParameter("endereco"));
		cartao.setNumero(request.getParameter("numero"));
		cartao.setBairro(request.getParameter("bairro"));
		cartao.setComplemento(request.getParameter("complemento"));
		cartao.setCep(request.getParameter("cep"));
		cartao.setRendimento(Float.parseFloat(request.getParameter("rendimentomensal")));
		cartao.setSenhaC(Integer.parseInt(request.getParameter("senhacartao")));
		cartao.setDataVenc(Integer.parseInt(request.getParameter("datavencimento")));
		cartao.setLimite(Float.parseFloat(request.getParameter("limite")));
		cartao.setSaldo(Float.parseFloat(request.getParameter("saldo")));
		cartaoDao.altera(cartao);
		response.sendRedirect("/cartao");
	}

	private void nova(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cartao cartao = new Cartao();
		request.setAttribute("cartao", cartao);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cartao/manter.jsp");	
		dispatcher.forward(request, response);	
	}
	
	private void edita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cartao cartao = new Cartao();
		int id = Integer.parseInt(request.getParameter("id"));

		cartao = cartaoDao.getById(id);
        request.setAttribute("cartao", cartao);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/cartao/manter.jsp");	
		dispatcher.forward(request, response);	
	}	

	private void remove(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Cartao cartao = new Cartao();
		cartao.setId(Integer.parseInt(request.getParameter("id")));

		cartaoDao.remove(cartao);
		response.sendRedirect("/cartao");
	}

	private void lista(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List <Cartao> cartoes = cartaoDao.getLista();
        request.setAttribute("cartoes", cartoes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cartao/consulta.jsp");
        dispatcher.forward(request, response);		

	}

}
