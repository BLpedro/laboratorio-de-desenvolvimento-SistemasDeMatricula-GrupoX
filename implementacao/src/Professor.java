package src;

public class Professor extends Usuario {

    public Professor(int id, String nome, String senha) {
        super(id, nome, senha);
    }

    public Professor(String nome, String senha) {
        super(nome, senha);
    }

    public void verificarAlunosMatriculados(Disciplina disciplina) {
        System.out.println("Alunos matriculados em " + disciplina.getNome() + ":");
        for (Aluno a : disciplina.getAlunos()) {
            System.out.println(a.getNome());
        }
    }

}
