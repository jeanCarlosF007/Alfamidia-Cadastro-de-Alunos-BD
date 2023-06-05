package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;

public class AlunoRepository implements BancoDeDados<Aluno>{
	
	public Aluno inserir(Aluno aluno) {
		String sql = "INSERT INTO alunos (nome) VALUES (?)";
		
		Connection conexao = ConexaoBD.obterConexao();
		
		try {
			
			PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, aluno.getNome());
			int resultado = ps.executeUpdate();
			
			if (resultado > 0) {
				System.out.println("Aluno cadastrado com sucesso!");
				
				ResultSet idGerado = ps.getGeneratedKeys();
				if (idGerado.next()) {
					int id = idGerado.getInt(1);
					aluno.setId(id);
				}
				idGerado.close();				
			}		
			return aluno;
		} catch (SQLException e) {
			System.out.println("Erro ao inserir o novo produto: " + e.getMessage());
			return null;
		} finally {
			ConexaoBD.fecharConexao();
		}
		
	}

	@Override
	public List<Aluno> consultaTodos() {
		List <Aluno> alunos = new ArrayList<>();
		String sql = "SELECT * FROM alunos";
		Connection conexao = ConexaoBD.obterConexao();
		
		try {
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet resultado = ps.executeQuery();
			
			while (resultado.next()) {
				int id = resultado.getInt(1);
				String nome = resultado.getString(2);
				Aluno aluno = new Aluno(id, nome);
				alunos.add(aluno);
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao exibir todos os cadastros " + e.getMessage());
			return null;
		} finally {
			ConexaoBD.fecharConexao();
		}
		return alunos;
	}

}
