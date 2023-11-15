package sem.dominio.dao;

import java.util.List;

import sem.dominio.entity.Despesa;

public interface DespesaDAO {

	public void insert(Despesa despesa);
	
	public Despesa getByObject(Despesa despesa);
	
	public Despesa getById(int id);
	
	public void deleteByObject(Despesa despesa);
	
	public void deleteById(int id);
	
	public void updateByObject(Despesa despesa);
	
	public void updateById(int id, double valor);
	
	public List<Despesa> getAll();
	
}
