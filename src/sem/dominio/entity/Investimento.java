package sem.dominio.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Investimento {
	private int idInvestimento, idConta, quantidadeAcao;
	private LocalDate dataInvestimento;
	private String nomeAcao, codigoAcao;
	private double valorInvestimento, valorAcao;
	
	public Investimento(int idInvestimento, int idConta, String dataInvestimento,
			double valorInvestimento, int quantidadeAcao, String nomeAcao, String codigoAcao, double valorAcao) {
		this.idInvestimento = idInvestimento;
		this.idConta = idConta;
		this.quantidadeAcao = quantidadeAcao;
		this.setDataInvestimento(dataInvestimento);
		this.nomeAcao = nomeAcao;
		this.codigoAcao = codigoAcao;
		this.valorInvestimento = valorInvestimento;
		this.valorAcao = valorAcao;
	}
	public Investimento(int idInvestimento, int idConta, LocalDate dataInvestimento,
			double valorInvestimento, int quantidadeAcao, String nomeAcao, String codigoAcao, double valorAcao) {
		this.idInvestimento = idInvestimento;
		this.idConta = idConta;
		this.quantidadeAcao = quantidadeAcao;
		this.dataInvestimento = dataInvestimento;
		this.nomeAcao = nomeAcao;
		this.codigoAcao = codigoAcao;
		this.valorInvestimento = valorInvestimento;
		this.valorAcao = valorAcao;
	}
	public LocalDate getDataInvestimento() {
		return this.dataInvestimento;
	}
	private void setDataInvestimento(String dataInvestimento) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataInvestimento = LocalDate.parse(dataInvestimento,formatter);
	}
	public double getValorInvestimento() {
		return valorInvestimento;
	}
	public void setValorInvestimento(double valorInvestimento) {
		this.valorInvestimento = valorInvestimento;
	}
	public double getValorAcao() {
		return valorAcao;
	}
	public void setValorAcao(double valorAcao) {
		this.valorAcao = valorAcao;
	}
	public int getIdInvestimento() {
		return idInvestimento;
	}
	public int getIdConta() {
		return idConta;
	}
	public int getQuantidadeAcao() {
		return quantidadeAcao;
	}
	public String getNomeAcao() {
		return nomeAcao;
	}
	public String getCodigoAcao() {
		return codigoAcao;
	}

}
