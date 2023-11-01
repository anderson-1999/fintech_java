package sem.dominio.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Receita {
	private int idReceita, idConta;
	private double valorEntrada;
	private LocalDate dataEntrada;
	
	public Receita(int idReceita, int idConta, double valorEntrada, String dataEntrada) {
		
		this.idReceita = idReceita;
		this.idConta = idConta;
		this.valorEntrada = valorEntrada;
		setDataEntrada(dataEntrada);
	}
	
	public LocalDate getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(String dataEntrada) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataEntrada = LocalDate.parse(dataEntrada,formatter);
	}
	public int getIdReceita() {
		return idReceita;
	}
	public int getIdConta() {
		return idConta;
	}
	public double getValorEntrada() {
		return valorEntrada;
	}
	
}
