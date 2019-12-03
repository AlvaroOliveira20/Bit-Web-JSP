package br.edu.cesmac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.cesmac.jdbc.ConnectionFactory;
import br.edu.cesmac.model.Cartao;
import br.edu.cesmac.model.Conta;

public class CartaoDao {
	private Connection connection;

	public CartaoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Cartao cartao) throws SQLException {
		String sql = "INSERT INTO cadastroCartao" + "(cpf , datanascimento, telefone, rg, orgaoexpedidor, endereco, numero, bairro, complemento, cep, rendimentomensal, senhacartao, datavencimento, limite, saldo)"+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement stmt;

			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, cartao.getCpf());
			stmt.setInt(2, cartao.getDataNasc());
			stmt.setString(3, cartao.getTelefone());
			stmt.setString(4, cartao.getRg());
			stmt.setString(5, cartao.getOrgExped());
			stmt.setString(6, cartao.getEndereco());
			stmt.setString(7, cartao.getNumero());
			stmt.setString(8, cartao.getBairro());
			stmt.setString(9, cartao.getComplemento());
			stmt.setString(10, cartao.getCep());
			stmt.setFloat(11, cartao.getRendimento());
			stmt.setInt(12, cartao.getSenhaC());
			stmt.setInt(13, cartao.getDataVenc());
			stmt.setFloat(14, cartao.getLimite());
			stmt.setFloat(15, cartao.getSaldo());
			stmt.execute();
			stmt.close();
	}

	public void altera(Cartao cartao) {
		String sql = "UPDATE cadastrocartao SET " + 
					"  cpf = ?, datanascimento = ?, telefone = ?, rg = ?, orgaoexpedidor = ?, endereco = ?, numero = ?, bairro = ?, complemento = ?, cep = ?, rendimentomensal = ?, senhacartao = ?, datavencimento = ?, limite = ?, saldo = ?"
					+ " WHERE id = ? ";

		try {
			PreparedStatement stmt = null;
			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, cartao.getCpf());
			stmt.setInt(2, cartao.getDataNasc());
			stmt.setString(3, cartao.getTelefone());
			stmt.setString(4, cartao.getRg());
			stmt.setString(5, cartao.getOrgExped());
			stmt.setString(6, cartao.getEndereco());
			stmt.setString(7, cartao.getNumero());
			stmt.setString(8, cartao.getBairro());
			stmt.setString(9, cartao.getComplemento());
			stmt.setString(10, cartao.getCep());
			stmt.setFloat(11, cartao.getRendimento());
			stmt.setInt(12, cartao.getSenhaC());
			stmt.setInt(13, cartao.getDataVenc());
			stmt.setFloat(14, cartao.getLimite());
			stmt.setFloat(15, cartao.getSaldo());
			stmt.setLong(16, cartao.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public void remove(Cartao cartao) {
		String sql = 	"DELETE FROM cadastrocartao " + 
						" WHERE id = ? ";

		try {
			PreparedStatement stmt;

			stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, cartao.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public Cartao getById(Integer id) {
		Cartao cartao = new Cartao();

		String sql = "SELECT id, cpf , datanascimento, telefone, rg, orgaoexpedidor, endereco, numero, bairro, complemento, cep, rendimentomensal, senhacartao, datavencimento, limite, saldo" 
				+ " FROM cadastrocartao " 
				+ " WHERE id = ?";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next()) {
				cartao.setId(resultado.getInt("id"));
				cartao.setCpf(resultado.getString("cpf"));
				cartao.setDataNasc(resultado.getInt("datanascimento"));
				cartao.setTelefone(resultado.getString("telefone"));
				cartao.setRg(resultado.getString("rg"));
				cartao.setOrgExped(resultado.getString("orgaoexpedidor"));
				cartao.setEndereco(resultado.getString("endereco"));
				cartao.setNumero(resultado.getString("numero"));
				cartao.setBairro(resultado.getString("bairro"));
				cartao.setComplemento(resultado.getString("complemento"));
				cartao.setCep(resultado.getString("cep"));
				cartao.setRendimento(resultado.getFloat("rendimentomensal"));
				cartao.setSenhaC(resultado.getInt("senhacartao"));
				cartao.setDataVenc(resultado.getInt("datavencimento"));
				cartao.setLimite(resultado.getFloat("limite"));
				cartao.setSaldo(resultado.getFloat("saldo"));
			}

			resultado.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

		return cartao;
	}	

	public List<Cartao> getLista() {
		List<Cartao> cartoes = new ArrayList<Cartao>();

		try {
			String sql = "SELECT id, cpf , datanascimento, telefone, rg, orgaoexpedidor, endereco, numero, bairro, complemento, cep, rendimentomensal, senhacartao, datavencimento, limite, saldo" 
						+ " FROM cadastrocartao " 
						+ " ORDER BY id";

			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();

			while (resultado.next()) {
				int ID = resultado.getInt("id");
				String CPF = resultado.getString("cpf");
				int DataNascimento = resultado.getInt("datanascimento");
				String Telefone = resultado.getString("telefone");
				String RG = resultado.getString("rg");
				String OrgaoExpedidor = resultado.getString("orgaoexpedidor");
				String Endereco = resultado.getString("endereco");
				String Numero = resultado.getString("numero");
				String Bairro = resultado.getString("bairro");
				String Complemento = resultado.getString("complemento");
				String CEP = resultado.getString("cep");
				float RendimentoMensal = resultado.getFloat("rendimentomensal");
				int SenhaCartao = resultado.getInt("senhacartao");
				int DataVencimento = resultado.getInt("datavencimento");
				float Limite = resultado.getFloat("limite");
				float Saldo = resultado.getFloat("saldo");
				
				Cartao cartao = new Cartao();
				cartao.setId(ID);
				cartao.setCpf(CPF);
				cartao.setDataNasc(DataNascimento);
				cartao.setTelefone(Telefone);
				cartao.setRg(RG);
				cartao.setOrgExped(OrgaoExpedidor);
				cartao.setEndereco(Endereco);
				cartao.setNumero(Numero);
				cartao.setBairro(Bairro);
				cartao.setComplemento(Complemento);
				cartao.setCep(CEP);
				cartao.setRendimento(RendimentoMensal);
				cartao.setSenhaC(SenhaCartao);
				cartao.setDataVenc(DataVencimento);
				cartao.setLimite(Limite);
				cartao.setSaldo(Saldo);

				cartoes.add(cartao);
			}

			resultado.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

		return cartoes;
	}

}
