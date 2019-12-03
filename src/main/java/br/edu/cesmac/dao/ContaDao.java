package br.edu.cesmac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.cesmac.jdbc.ConnectionFactory;
import br.edu.cesmac.model.Conta;

public class ContaDao {
	private Connection connection;

	public ContaDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Conta conta) throws SQLException {
		String sql = "INSERT INTO conta" + "(nome, cpf, email, senha)"+ " values (?, ?, ?, ?)";

			PreparedStatement stmt;

			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, conta.getNome());
			stmt.setString(2, conta.getCpf());
			stmt.setString(3, conta.getEmail());
			stmt.setString(4, conta.getSenha());
			stmt.execute();
			stmt.close();
	}

	public void altera(Conta conta) {
		String sql = "UPDATE conta SET " + 
					" nome = ?, cpf = ?, email = ?, senha = ?"
					+ " WHERE idConta = ? ";

		try {
			PreparedStatement stmt = null;
			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, conta.getNome());
			stmt.setString(2, conta.getCpf());
			stmt.setString(3, conta.getEmail());
			stmt.setString(4, conta.getSenha());
			stmt.setLong(5, conta.getIdConta());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public void remove(Conta conta) {
		String sql = 	"DELETE FROM conta " + 
						" WHERE idConta = ? ";

		try {
			PreparedStatement stmt;

			stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, conta.getIdConta());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public Conta getById(Integer id) {
		Conta conta = new Conta();

		String sql = "SELECT idConta, nome, email, cpf, senha" 
				+ " FROM conta " 
				+ " WHERE idConta = ?";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next()) {
				conta.setIdConta(resultado.getInt("idConta"));
				conta.setNome(resultado.getString("nome"));
				conta.setCpf(resultado.getString("cpf"));
				conta.setEmail(resultado.getString("email"));
				conta.setSenha(resultado.getString("senha"));
			}

			resultado.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

		return conta;
	}	

	public List<Conta> getLista() {
		List<Conta> contas = new ArrayList<Conta>();

		try {
			String sql = "SELECT idConta, nome, email, cpf, senha" 
						+ " FROM conta " 
						+ " ORDER BY nome";

			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();

			while (resultado.next()) {
				int id = resultado.getInt("idConta");
				String nome = resultado.getString("nome");
				String cpf = resultado.getString("cpf");
				String email = resultado.getString("email");
				String senha = resultado.getString("senha");

				Conta conta = new Conta();
				conta.setIdConta(id);
				conta.setNome(nome);
				conta.setCpf(cpf);
				conta.setEmail(email);
				conta.setSenha(senha);

				contas.add(conta);
			}

			resultado.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

		return contas;
	}

}
