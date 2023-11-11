package sem.dominio.dao;

import java.util.List;

import sem.dominio.entity.Telefone;

public interface TelefoneDAO {

	public void insert(Telefone telefone);
	
	public Telefone getByObject(Telefone telefone);
	
	public Telefone getById(int id);
	
	public void deleteByObject(Telefone telefone);
	
	public void deleteById(int id);
	
	public void updateByObject(Telefone telefone);
	
	public void updateById(int id, String senha, double credito);
	
	public List<Telefone> getAll();
	
}
