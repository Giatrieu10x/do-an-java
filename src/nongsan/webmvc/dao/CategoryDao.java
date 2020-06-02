package nongsan.webmvc.dao;

import java.util.List;

import nongsan.webmvc.model.Catalog;

public interface CategoryDao {
	void insert(Catalog category);

	void edit(Catalog category);

	void delete(String id);

	Catalog get(int id);
	
	Catalog get(String name);

	List<Catalog> getAll();

}
