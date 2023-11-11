package sem.dominio.dao;

import java.util.List;

import sem.dominio.entity.Receita;

public interface ReceitaDAO {

	public void insert(Receita receita);
	
	public Receita getByObject(Receita receita);
	
	public Receita getById(int id);
	
	public void deleteByObject(Receita receita);
	
	public void deleteById(int id);
	
	public void updateByObject(Receita receita);
	
	public void updateById(int id, String senha, double credito);
	
	public List<Receita> getAll();
	
}
