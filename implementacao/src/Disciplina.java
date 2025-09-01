package src;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {

    private String nome;
    private String codigo;
    private boolean obrigatorio;
    private List<Aluno> alunos;
    private Professor professor;

    private static final int MAX_ALUNOS = 60;
    private static final int MIN_ALUNOS = 3;

    public Disciplina(String nome, String codigo, boolean obrigatorio, Professor professor) {
        if (professor == null)
            throw new IllegalArgumentException("Professor não pode ser nulo");
        this.nome = nome;
        this.codigo = codigo;
        this.obrigatorio = obrigatorio;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }

    public boolean isAtiva() {
        return alunos.size() >= MIN_ALUNOS;
    }

    public boolean temVaga() {
        return alunos.size() < MAX_ALUNOS;
    }

    public void adicionarAluno(Aluno aluno) {
        if (!temVaga())
            throw new RuntimeException("Não há mais vagas nesta disciplina!");
        if (alunos.contains(aluno))
            throw new RuntimeException("Aluno já está matriculado nesta disciplina!");
        alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        if (!alunos.remove(aluno))
            throw new RuntimeException("Aluno não encontrado nesta disciplina!");
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public boolean isObrigatorio() {
        return obrigatorio;
    }

    public List<Aluno> getAlunos() {
        return new ArrayList<>(alunos);
    }

    public Professor getProfessor() {
        return professor;
    }

    public int getQtdAlunos() {
        return alunos.size();
    }
}
