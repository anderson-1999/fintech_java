package sem.dominio.dao;

import java.util.List;

import sem.dominio.entity.Conta;

public interface ContaDAO {
	
	public void insert(Conta conta);
	
	public Conta getByObject(Conta conta);
	
	public Conta getById(int id);
	
	public void deleteByObject(Conta conta);
	
	public void deleteById(int id);
	
	public void updateByObject(Conta conta);
	
	public void updateById(int id, String senha, double saldo, double lis, double seguro, double cesta, double limite);
	
	public List<Conta> getAll();
	
}
