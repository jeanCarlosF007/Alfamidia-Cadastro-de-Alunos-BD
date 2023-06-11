import java.util.Scanner;

import model.Aluno;
import repository.AlunoRepository;

public class Principal {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		AlunoRepository alunoRepository = new AlunoRepository();
		
		System.out.println("BEM-VINDO!!! \n");
		do {
			System.out.println("==================================");
			System.out.println("Selecione o que deseja fazer:");
			System.out.println("0 - Sair do sistema;");
			System.out.println("1 - Adicionar um cadastro");
			System.out.println("2 - Excluir um cadastro;");
			System.out.println("3 - Atualizar um cadastro");
			System.out.println("4 - Visualizar todos os cadastros");
			System.out.println("==================================");

			int opcao = sc.nextInt();
			
			if (opcao == 1) {
				
				System.out.println("Digite o nome do aluno que deseja adicionar: ");
				sc.nextLine();
				String nome = sc.nextLine();
				Aluno aluno = new Aluno(nome);
				alunoRepository.inserir(aluno);				
				
			} else if (opcao == 2) {
				
				alunoRepository.consultaTodos().forEach(System.out::println);
				
				do {
					System.out.println("Digite o ID do aluno acima que deseja deletar");
					int idDeletar = sc.nextInt();
					System.out.println("Você tem certeza que deseja deletar o aluno " + alunoRepository.buscarPorId(idDeletar) + "? \n Digite '1' para confirmar ou qualquer outro número para cancelar");
					int confirma = sc.nextInt();

					if (confirma == 1) {
						alunoRepository.deletar(idDeletar);
						break;
					} else if (confirma != 1){
						System.out.println("Você ainda deseja deletar um aluno?");
						System.out.println("1 - Sim");
						System.out.println("2 - Não");
						int continuaDelete = sc.nextInt();
						if (continuaDelete == 1) {
							continue;
						} else if (continuaDelete == 2) {
							break;
						} else {
							System.out.println("Opção inválida. Retornando às opções iniciais");
							break;
						}
					}
				} while (true);
				
			} else if (opcao == 3) {
				
				alunoRepository.consultaTodos().forEach(System.out::println);				
				System.out.println("Digite o ID do cadastro que deseja atualizar: ");
				int idAtualizar = sc.nextInt();
				System.out.println("Digite o nome a ser colocado no lugar do atual: ");
				sc.nextLine();
				String nomeAtualizar = sc.nextLine();
				Aluno aluno = new Aluno(idAtualizar, nomeAtualizar);
				alunoRepository.atualizar(aluno);
				
			} else if (opcao == 4) {
				
				System.out.println("Abaixo estão todos os cadastros até o momento: ");
				alunoRepository.consultaTodos().forEach(System.out::println);
				
			} else if (opcao == 0) {
				System.out.println("Você saiu do sistema.");
				break;
			} else {
				System.out.println("Comando inválido! Digite um valor de 1 a 5!");
			}
		} while (true);		
	}
}