package sem.dominio.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Despesa {
	private int idDespesa, idConta;
	private double valorSaida;
	private LocalDate dataSaida;
	
	public Despesa(int idPessoa, int idConta, double valorSaida, LocalDate dataSaida) {
		
		this.idDespesa = idPessoa;
		this.idConta = idConta;
		this.valorSaida = valorSaida;
		this.dataSaida = dataSaida;
	}
	public Despesa(int idPessoa, int idConta, double valorSaida, String dataSaida) {
		
		this.idDespesa = idPessoa;
		this.idConta = idConta;
		this.valorSaida = valorSaida;
		this.setDataSaida(dataSaida);
	}
	public LocalDate getDataSaida() {
		return this.dataSaida;
	}
	public void setDataSaida(String dataSaida) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataSaida = LocalDate.parse(dataSaida,formatter);
	}
	public int getIdDespesa() {
		return idDespesa;
	}
	public int getIdConta() {
		return idConta;
	}
	public double getValorSaida() {
		return valorSaida;
	}
	

}
