package br.edu.cesmac.model;

public class Conta {
	private int idConta;
	private String nome;
	private String cpf;
	private String email;
	private String senha;

	public Conta() {

	}

	public Conta(String nome, int idConta, String cpf, String email, String senha) {
		this.nome = nome;
		this.idConta = idConta;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
	}

	public int getIdConta() {
		return idConta;
	}

	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}