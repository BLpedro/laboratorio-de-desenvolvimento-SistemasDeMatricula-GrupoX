package src;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    
    private String nome;
    private String codigo;
    private boolean obrigatorio;
    private List<Aluno> alunos;
    private Professor professor;
    private int qtdAlunos;
    private boolean podeMatricular;

    private static final int MAX_ALUNOS = 60;
    private static final int MIN_ALUNOS = 3;

    public Disciplina(String nome, String codigo, boolean obrigatorio, Professor professor) {
        if (professor == null) {
            throw new IllegalArgumentException("Professor não pode ser nulo");
        }
        this.nome = nome;
        this.codigo = codigo;
        this.obrigatorio = obrigatorio;
        this.professor = professor;
        this.alunos = new ArrayList<>();
        this.qtdAlunos = 0;
    }

    public boolean validarDisciplina() {
        return qtdAlunos >= MIN_ALUNOS;
    }

    public boolean temVaga() {
        return qtdAlunos < MAX_ALUNOS;
    }

    public void adicionarAluno(Aluno aluno) {
        if (!verificarPeriodo()) {
            throw new RuntimeException("Matrícula ainda não está aberta!");
        }
        if (!temVaga()) {
            throw new RuntimeException("Não há mais vagas nesta disciplina!");
        }
        if (alunos.contains(aluno)) {
            throw new RuntimeException("Aluno já está matriculado nesta disciplina!");
        }
        alunos.add(aluno);
        qtdAlunos++;
    }

    public void removerAluno(Aluno aluno) {
        if (!alunos.remove(aluno)) {
            throw new RuntimeException("Aluno não encontrado nesta disciplina!");
        }
        qtdAlunos--;
    }

    public boolean verificarPeriodo() {
        return podeMatricular;
    }

    public void abrirMatriculas() {
        this.podeMatricular = true;
    }

    public void fecharMatriculas() {
        this.podeMatricular = false;
    }

    // Getters e Setters

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
        return qtdAlunos;
    }
}
