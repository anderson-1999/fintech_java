package sem.dominio.entity;

public class pessoa {
	private int idConta, idPessoa;
	private double saldo, lisConta, cestaDeProduto, limiteCredito, seguroCartao;
	private String numeroDaAgencia, numeroDaConta, senhaConta;

	public pessoa(int idConta, int idPessoa, String numeroDaAgencia, String numeroDaConta, double saldo, double lisConta, double seguroCartao, double cestaDeProduto, double limiteCredito, String senhaConta) {
		this.idConta = idConta;
		this.idPessoa = idPessoa;
		this.saldo = saldo;
		this.lisConta = lisConta;
		this.cestaDeProduto = cestaDeProduto;
		this.limiteCredito = limiteCredito;
		this.numeroDaAgencia = numeroDaAgencia;
		this.numeroDaConta = numeroDaConta;
		this.senhaConta = senhaConta;
		this.seguroCartao = seguroCartao;
	}

	public double getSeguroCartao() {
		return seguroCartao;
	}

	public void setSeguroCartao(double seguroCartao) {
		this.seguroCartao = seguroCartao;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getLisConta() {
		return lisConta;
	}

	public void setLisConta(double lisConta) {
		this.lisConta = lisConta;
	}

	public double getCestaDeProduto() {
		return cestaDeProduto;
	}

	public void setCestaDeProduto(double cestaDeProduto) {
		this.cestaDeProduto = cestaDeProduto;
	}

	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public String getSenhaConta() {
		return senhaConta;
	}

	public void setSenha(String senha) {
		this.senhaConta = senha;
	}

	public int getIdConta() {
		return idConta;
	}

	public String getNumeroDaAgencia() {
		return numeroDaAgencia;
	}

	public String getNumeroDaConta() {
		return numeroDaConta;
	}
	

}
