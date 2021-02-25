package db;

import java.util.List;

//p. 479
public interface DAO<T> {
	T getById(int id);
	List<T> getAll();
	boolean add(T t);
	boolean update(T t);
	boolean delete(T t);
}
