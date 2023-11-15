package sem.dominio.entity;

public class Endereco {
	private int idEndereco, idPessoa;
	private String numeroDoCep, tipoLogradouro, nomeLogradouro, numeroDaResidencia, tipoDaResidencia, nomeBarrio, complemento;

	public Endereco(int idEndereco, int idPessoa, String numeroDoCep, String nomeBarrio, String tipoLogradouro,
			String nomeLogradouro, String complemento, String numeroDaResidencia,  String tipoDaResidencia) {
		this.idEndereco = idEndereco;
		this.idPessoa = idPessoa;
		this.tipoLogradouro = tipoLogradouro;
		this.nomeLogradouro = nomeLogradouro;
		this.numeroDaResidencia = numeroDaResidencia;
		this.numeroDoCep = numeroDoCep;
		this.tipoDaResidencia = tipoDaResidencia;
		this.nomeBarrio = nomeBarrio;
		this.complemento = complemento;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getNomeLogradouro() {
		return nomeLogradouro;
	}

	public void setNomeLogradouro(String nomeLogradouro) {
		this.nomeLogradouro = nomeLogradouro;
	}

	public String getNumeroDaResidencia() {
		return numeroDaResidencia;
	}

	public void setNumeroDaResidencia(String numeroDaResidencia) {
		this.numeroDaResidencia = numeroDaResidencia;
	}

	public String getNumeroDoCep() {
		return this.numeroDoCep;
	}

	public void setNumeroDoCep(String cep) {
		this.numeroDoCep = cep;
	}

	public String getTipoDaResidencia() {
		return tipoDaResidencia;
	}

	public void setTipoDaResidencia(String tipoDaResidencia) {
		this.tipoDaResidencia = tipoDaResidencia;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public String getNomeBarrio() {
		return nomeBarrio;
	}

	public void setNomeBarrio(String nomeBarrio) {
		this.nomeBarrio = nomeBarrio;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
