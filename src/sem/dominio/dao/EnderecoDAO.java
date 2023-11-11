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
	
	public void updateById(int id);
	
	public List<Endereco> getAll();
	
}
