package sem.dominio.dao;

import java.util.List;

import sem.dominio.entity.Investimento;

public interface InvestimentoDAO {
	
	public void insert(Investimento investimento);
	
	public Investimento getByObject(Investimento investimento);
	
	public Investimento getById(int id);
	
	public void deleteByObject(Investimento investimento);
	
	public void deleteById(int id);
	
	public void updateByObject(Investimento investimento);
	
	public void updateById(int id, double valorTotal, double valorAcao);
	
	public List<Investimento> getAll();
	
}
