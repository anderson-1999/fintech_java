package sem.dominio.dao;

import java.util.List;

import sem.dominio.entity.Pix;

public interface PixDAO {

	public void insert(Pix pix);
	
	public Pix getByObject(Pix pix);
	
	public Pix getById(int id);
	
	public void deleteByObject(Pix pix);
	
	public void deleteById(int id);
	
	public void updateByObject(Pix pix);
	
	public void updateById(int id, double limite, int quantidade);
	
	public List<Pix> getAll();
	
}
