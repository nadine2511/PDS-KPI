package fr.esiag.sim.dao;

import java.util.List;

public interface AbstractDAO<T> {
	
	public void add(T o);
	public List<T> list();
	void createTable();

}
