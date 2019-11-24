package br.edu.cesmac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.cesmac.jdbc.ConnectionFactory;
import br.edu.cesmac.model.Cadastro;

public class CadastroDao {
	private Connection connection;

	public CadastroDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Cadastro cadastro) throws SQLException {
		String sql = "INSERT INTO cadastro" + " (nome)" + " values (?)";

			PreparedStatement stmt;

			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, cadastro.getNome());
			stmt.execute();
			stmt.close();
	}

	public void altera(Cadastro cadastro) {
		String sql = "UPDATE cadastro SET " + 
					" nome = ?, cpf = ?, email = ?, senha = ?"
					+ " WHERE idCadastro = ? ";

		try {
			PreparedStatement stmt = null;
			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, cadastro.getNome());
			stmt.setString(2, cadastro.getCpf());
			stmt.setString(3, cadastro.getEmail());
			stmt.setString(4, cadastro.getSenha());
			stmt.setLong(5, cadastro.getIdCadastro());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public void remove(Cadastro cadastro) {
		String sql = 	"DELETE FROM cadastro " + 
						" WHERE idCadastro = ? ";

		try {
			PreparedStatement stmt;

			stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, cadastro.getIdCadastro());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public Cadastro getById(Integer id) {
		Cadastro cadastro = new Cadastro();

		String sql = "SELECT idCadastro, nome, email, cpf, senha" 
				+ " FROM cadastro " 
				+ " WHERE idCadastro = ?";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next()) {
				cadastro.setIdCadastro(resultado.getInt("idCadastro"));
				cadastro.setNome(resultado.getString("nome"));
				cadastro.setCpf(resultado.getString("cpf"));
				cadastro.setEmail(resultado.getString("email"));
				cadastro.setSenha(resultado.getString("senha"));
			}

			resultado.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

		return cadastro;
	}	

	public List<Cadastro> getLista() {
		List<Cadastro> cadastros = new ArrayList<Cadastro>();

		try {
			String sql = "SELECT idCadastro, nome, email, cpf, senha" 
						+ " FROM cadastro " 
						+ " ORDER BY nome";

			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();

			while (resultado.next()) {
				int id = resultado.getInt("idCadastro");
				String nome = resultado.getString("nome");
				String cpf = resultado.getString("cpf");
				String email = resultado.getString("email");
				String senha = resultado.getString("senha");

				Cadastro cadastro = new Cadastro();
				cadastro.setIdCadastro(id);
				cadastro.setNome(nome);
				cadastro.setCpf(cpf);
				cadastro.setEmail(email);
				cadastro.setSenha(senha);

				cadastros.add(cadastro);
			}

			resultado.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

		return cadastros;
	}

}
