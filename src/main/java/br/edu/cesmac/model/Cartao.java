package br.edu.cesmac.model;

public class Cartao {
	private int id;
	private int dataNasc;
	private String cpf;
	private String telefone;
	private String rg;
	private String orgExped;
	private String endereco;
	private String numero;
	private String bairro;
	private String complemento;
	private String cep;
	private float rendimento;
	private int senhaC;
	private int dataVenc;
	private float limite;
	private float saldo;
	

	public Cartao() {

	}


	public Cartao(int id, int dataNasc, String cpf, String telefone, String rg, String orgExped, String endereco,
			String numero, String bairro, String complemento, String cep, float rendimento, int senhaC, int dataVenc,
			float limite, float saldo) {
		super();
		this.id = id;
		this.dataNasc = dataNasc;
		this.cpf = cpf;
		this.telefone = telefone;
		this.rg = rg;
		this.orgExped = orgExped;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cep = cep;
		this.rendimento = rendimento;
		this.senhaC = senhaC;
		this.dataVenc = dataVenc;
		this.limite = limite;
		this.saldo = saldo;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(int dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgExped() {
		return orgExped;
	}

	public void setOrgExped(String orgExped) {
		this.orgExped = orgExped;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public float getRendimento() {
		return rendimento;
	}

	public void setRendimento(float rendimento) {
		this.rendimento = rendimento;
	}

	public int getSenhaC() {
		return senhaC;
	}

	public void setSenhaC(int senhaC) {
		this.senhaC = senhaC;
	}

	public int getDataVenc() {
		return dataVenc;
	}

	public void setDataVenc(int dataVenc) {
		this.dataVenc = dataVenc;
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}


}