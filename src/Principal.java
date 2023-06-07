import model.Aluno;
import repository.AlunoRepository;

public class Principal {
	
	public static void main(String[] args) {
	
		AlunoRepository alunoRepository = new AlunoRepository();
		System.out.println(alunoRepository.consultaTodos());
		
		
		System.out.println(alunoRepository.buscarPorId(4));
		
		
		
	}
	
}
