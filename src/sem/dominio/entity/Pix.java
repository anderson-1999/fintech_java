package sem.dominio.entity;

public class Pix {
	
	private int idPix, idConta, quantidadeTransacao;
	private String chavePix; 
	private double limiteTransacao;
	
	public Pix(int idPix, int idConta, String chavePix, double limiteTransacao, int quantidadeTransacao) {
		this.idPix = idPix;
		this.idConta = idConta;
		this.chavePix = chavePix;
		this.limiteTransacao = limiteTransacao;
		this.quantidadeTransacao = quantidadeTransacao;
	}

	public int getQuantidadeTransacao() {
		return quantidadeTransacao;
	}

	public void setQuantidadeTransacao(int quantidadeTransacao) {
		this.quantidadeTransacao = quantidadeTransacao;
	}

	public double getLimiteTransacao() {
		return limiteTransacao;
	}

	public void setLimiteTransacao(double limiteTransacao) {
		this.limiteTransacao = limiteTransacao;
	}

	public int getIdConta() {
		return idConta;
	}

	public String getChavePix() {
		return chavePix;
	}

	public int getIdPix() {
		return idPix;
	}
	
}
