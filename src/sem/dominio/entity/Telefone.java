package sem.dominio.entity;

public class Telefone {
	private int idNumero, idPessoa;
	private String ddiDoNumero, dddDoNumero, numeroTelefonico, tipoDoTelefone;

	public Telefone(int idNumero, int idPessoa, String ddiDoNumero, String dddDoNumero, String numeroTelefonico,
			String tipoDoTelefone) {
		this.idNumero = idNumero;
		this.idPessoa = idPessoa;
		this.ddiDoNumero = ddiDoNumero;
		this.dddDoNumero = dddDoNumero;
		this.numeroTelefonico = numeroTelefonico;
		this.tipoDoTelefone = tipoDoTelefone;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public int getIdNumero() {
		return idNumero;
	}

	public String getDdiDoNumero() {
		return ddiDoNumero;
	}

	public void setDdiDoNumero(String ddiDoNumero) {
		this.ddiDoNumero = ddiDoNumero;
	}

	public String getDddDoNumero() {
		return dddDoNumero;
	}

	public void setDddDoNumero(String dddDoNumero) {
		this.dddDoNumero = dddDoNumero;
	}

	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}

	public String getTipoDoTelefone() {
		return tipoDoTelefone;
	}

	public void setTipoDoTelefone(String tipoDoTelefone) {
		this.tipoDoTelefone = tipoDoTelefone;
	}

}
