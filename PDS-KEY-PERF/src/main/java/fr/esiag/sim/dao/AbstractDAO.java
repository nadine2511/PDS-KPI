package fr.esiag.sim.dao;

import java.util.List;

public interface AbstractDAO<T> {
	
	public List<T> list();
	public T getById(int id);

}
