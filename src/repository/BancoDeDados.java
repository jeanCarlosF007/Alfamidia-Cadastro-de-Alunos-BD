package repository;

import java.util.List;

public interface BancoDeDados <T> {
	
	public T inserir (T t);
	public List<T> consultaTodos();

}
