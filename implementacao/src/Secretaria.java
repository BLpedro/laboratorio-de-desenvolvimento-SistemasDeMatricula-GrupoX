package src;

import java.util.List;

public class Secretaria extends Usuario {

    public Secretaria(String nome, String senha) {
        super(nome, senha);
    }

    // Alunos
    public void adicionarAluno(Aluno aluno, List<Aluno> alunos) {
        alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno, List<Aluno> alunos) {
        alunos.remove(aluno);
    }

    // Professores
    public void adicionarProfessor(Professor professor, List<Professor> professores) {
        professores.add(professor);
    }

    public void removerProfessor(Professor professor, List<Professor> professores) {
        professores.remove(professor);
    }

    // Disciplinas
    public void adicionarDisciplina(Disciplina disciplina, List<Disciplina> disciplinas) {
        disciplinas.add(disciplina);
    }

    public void removerDisciplina(Disciplina disciplina, List<Disciplina> disciplinas) {
        disciplinas.remove(disciplina);
    }
}
