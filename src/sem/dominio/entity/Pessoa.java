package sem.dominio.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {
	
	protected int idPessoa;
	protected String nome, email, numeroCpfCnpj, sobrenome = null;
	protected LocalDate dataNascimento;
	
	
	public Pessoa (String nome, String email, String data,  String cpfCpnj, String sobrenome) {
		this.nome = nome;
		this.email = email;
		this.numeroCpfCnpj = cpfCpnj;
		this.sobrenome = sobrenome;
		
		this.setDataNascimento(data);
	}
	public Pessoa (int idPessoa, String nome, String email, LocalDate dataNascimento, String cpfCpnj, String sobrenome) {
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.numeroCpfCnpj = cpfCpnj;
		this.sobrenome = sobrenome;
	}

	public String getNumeroCpfCnpj() {
		return numeroCpfCnpj;
	}
	public int getIdPessoa() {
		return idPessoa;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	
	public LocalDate getDataNascimento() {
		
		return this.dataNascimento;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}	
	
	
	private void setDataNascimento(String data) {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
         dataNascimento = LocalDate.parse(data,formatter);
	}
	public String toString() {
		return idPessoa + " " + nome +  " " + sobrenome + " " + email + " " + dataNascimento + " " + numeroCpfCnpj ;
	}
	

}