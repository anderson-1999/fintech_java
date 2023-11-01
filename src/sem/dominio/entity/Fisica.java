package sem.dominio.entity;

import java.time.LocalDate;

public class Fisica extends Pessoa {

	public Fisica(int idPessoa, String cpf, String nome, String sobrenome, String email, LocalDate dataNascimento) {

		super(idPessoa, nome, email, dataNascimento, cpf, sobrenome);
	}

	public Fisica(String cpf, String nome, String sobrenome, String email, String dataNascimento) {

		super(nome, email, dataNascimento, cpf, sobrenome);
	}

}
