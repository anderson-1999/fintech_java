package sem.dominio.dao;

import java.util.List;

import sem.dominio.entity.Pessoa;

public interface PessoaDAO {
	
	public void insert(Pessoa pessoa);
	
	public Pessoa getByObject(Pessoa pessoa);
	
	public Pessoa getById(int id);
	
	public void deleteByObject(Pessoa pessoa);
	
	public void deleteById(int id);
	
	public void updateByObject(Pessoa pessoa);
	
	public void updateById(int id, String email);
	
	public List<Pessoa> getAll();
	
}
