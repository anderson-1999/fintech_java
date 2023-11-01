package sem.dominio.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cartao {
	private int idCartao, idConta;
	private String numeroDoCartao, cvv, nomeDoCartao, senhaDoCartao;
	private LocalDate vencimentoDoCartao;
	private double limiteCredito;
	private boolean cartaoVirtual;
	
	public Cartao(int idCartao, int idConta, String numeroDoCartao, String cvv, String nomeDoCartao,
			String senhaDoCartao, String vencimentoDoCartao, double limiteCredito) {
		this.idCartao = idCartao;
		this.idConta = idConta;
		this.numeroDoCartao = numeroDoCartao;
		this.cvv = cvv;
		this.nomeDoCartao = nomeDoCartao;
		this.setVencimento(vencimentoDoCartao);
		this.senhaDoCartao = senhaDoCartao;
		this.limiteCredito = limiteCredito;
		//cartaoVirtual = tipoCartao == "virtual" ? true : false;
	}
	private void setVencimento(String data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        vencimentoDoCartao = LocalDate.parse(data,formatter);
	}
	public Cartao(int idCartao, int idConta, String numeroDoCartao, String cvv, String nomeDoCartao,
			String senhaDoCartao, LocalDate vencimentoDoCartao, double limiteCredito) {
		this.idCartao = idCartao;
		this.idConta = idConta;
		this.numeroDoCartao = numeroDoCartao;
		this.cvv = cvv;
		this.nomeDoCartao = nomeDoCartao;
		this.vencimentoDoCartao = vencimentoDoCartao;
		this.senhaDoCartao = senhaDoCartao;
		this.limiteCredito = limiteCredito;
	}
	
	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public int getIdConta() {
		return idConta;
	}

	public String getSenhaDoCartao() {
		return senhaDoCartao;
	}

	public void setSenhaDoCartao(String senhaDoCartao) {
		this.senhaDoCartao = senhaDoCartao;
	}

	public int getIdCartao() {
		return idCartao;
	}

	public String getNumeroDoCartao() {
		return numeroDoCartao;
	}

	public String getCvv() {
		return cvv;
	}

	public String getNomeDoCartao() {
		return nomeDoCartao;
	}

	public LocalDate getVencimentoDoCartao() {
		return vencimentoDoCartao;
	}
	
	public String toString() {
		return idCartao + " " + idConta +  " " + numeroDoCartao + " " + cvv + " " + nomeDoCartao + " " 
	+ senhaDoCartao + " " + vencimentoDoCartao + " " + limiteCredito ;
	}

}
