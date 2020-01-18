package tolkien.lotr.repository;

import java.util.List;

public interface Repository<E>{
	
	public void insert(E element);
	
	public List<E> listAll();

	public E findBy(Integer id);

	public void update(E element);
	
}