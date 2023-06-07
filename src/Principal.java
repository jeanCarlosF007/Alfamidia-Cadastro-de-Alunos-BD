import model.Aluno;
import repository.AlunoRepository;

public class Principal {
	
	public static void main(String[] args) {
	
		AlunoRepository alunoRepository = new AlunoRepository();
		System.out.println(alunoRepository.consultaTodos());
		
		Aluno aluno = new Aluno(1, "Marcos");
		alunoRepository.atualizar(aluno);
		alunoRepository.consultaTodos().forEach(System.out::println);
		
		
	}
	
}
