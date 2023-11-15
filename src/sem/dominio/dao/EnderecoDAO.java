package sem.dominio.dao;

import java.util.List;

import sem.dominio.entity.Endereco;

public interface EnderecoDAO {
	
	public void insert(Endereco endereco);
	
	public Endereco getByObject(Endereco endereco);
	
	public Endereco getById(int id);
	
	public void deleteByObject(Endereco endereco);
	
	public void deleteById(int id);
	
	public void updateByObject(Endereco endereco);
	
	public void updateById(int id, String numeroDoCep, String nomeBarrio, String tipoLogradouro, String nomeLogradouro,
			String numeroDaResidde, String complemento, String tipoDaResidencia);
	
	public List<Endereco> getAll();
	
}
