package br.edu.cesmac.model;

public class Cadastro {
	private int idCadastro;
	private String nome;
	private String cpf;
	private String email;
	private String senha;

	public Cadastro() {

	}

	public Cadastro(String nome, int idCadastro, String cpf, String email, String senha) {
		this.nome = nome;
		this.idCadastro = idCadastro;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
	}

	public int getIdCadastro() {
		return idCadastro;
	}

	public void setIdCadastro(int idCadastro) {
		this.idCadastro = idCadastro;
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