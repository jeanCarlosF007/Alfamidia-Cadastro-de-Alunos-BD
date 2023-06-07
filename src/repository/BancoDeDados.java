package repository;

import java.util.List;

public interface BancoDeDados <T> {
	
	public T inserir (T t);
	public List<T> consultaTodos();
	public T atualizar (T t);
	public void deletar(int id);
	public T buscarPorId (int id);

}
