package sem.dominio.entity;

import java.time.LocalDate;

public class Juridica extends Pessoa {
	
	private String inscricaoEstudal, inscricaoMunicipal;

	public Juridica(int id, String cnpj, String nome, String sobrenome, String email, LocalDate data) {
		super(id, nome, email, data, cnpj, null);
				
	}
	public Juridica( String cnpj, String nome, String email, String data) {
		super(nome, email, data, cnpj, null);
	}
}
