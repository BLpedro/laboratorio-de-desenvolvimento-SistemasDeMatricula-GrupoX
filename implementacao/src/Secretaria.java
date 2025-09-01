//package src;

import java.util.List;

public class Secretaria extends Usuario {

    private boolean periodoMatriculaAberto;

    public Secretaria(String nome, String senha) {
        super(nome, senha);
        this.periodoMatriculaAberto = false;
    }

    public void abrirMatricula() {
        periodoMatriculaAberto = true;
    }

    public void fecharMatricula() {
        periodoMatriculaAberto = false;
    }

    public boolean isPeriodoMatriculaAberto() {
        return periodoMatriculaAberto;
    }

    public void adicionarAluno(Aluno aluno, List<Aluno> alunos) {
        alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno, List<Aluno> alunos) {
        alunos.remove(aluno);
    }

    public void adicionarProfessor(Professor professor, List<Professor> professores) {
        professores.add(professor);
    }

    public void removerProfessor(Professor professor, List<Professor> professores) {
        professores.remove(professor);
    }

    public void adicionarDisciplina(Disciplina disciplina, List<Disciplina> disciplinas) {
        disciplinas.add(disciplina);
    }

    public void removerDisciplina(Disciplina disciplina, List<Disciplina> disciplinas) {
        disciplinas.remove(disciplina);
    }

    public void encerrarMatriculas(List<Disciplina> disciplinas) {
        fecharMatricula();
        for (Disciplina d : disciplinas) {
            if (!d.isAtiva()) {
                System.out.println("Disciplina " + d.getNome() + " será cancelada por não atingir o mínimo de alunos.");
            }
        }
    }
}
