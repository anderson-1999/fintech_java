package sem.dominio.dao;

import java.util.List;

import sem.dominio.entity.Cartao;

public interface CartaoDAO {
	
	public void insert(Cartao cartao);
	
	public Cartao getByObject(Cartao cartao);
	
	public Cartao getById(int id);
	
	public void deleteByObject(Cartao cartao);
	
	public void deleteById(int id);
	
	public void updateByObject(Cartao cartao);
	
	public void updateById(int id, String senha, double credito);
	
	public List<Cartao> getAll();
	
}
