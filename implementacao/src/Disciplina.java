package src;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    String  codigo;
    String materia;
    boolean obrigatoria;
    private boolean ativa;
    Curso curso;
    Professor professor;
    int creditos;
    List<Aluno> alunos;

      public static final int MIN_ALUNOS = 3;
    public static final int MAX_ALUNOS = 60;


     public Disciplina(String codigo, String materia, int creditos, Professor professor) {
        this.codigo = codigo;
        this.materia = materia;
        this.creditos = creditos;
        this.professor = professor;
        this.alunos = new ArrayList<>();
        this.ativa = false;
        this.obrigatoria = false;
    }

    
    public boolean adicionarAluno(Aluno aluno) {
        return false;
    }

    public boolean removerAluno(Aluno aluno) {
        return false;
    }

    public boolean verificarAtividade() {
        return false;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }


    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }


    public String getMateria() {
        return materia;
    }


    public void setMateria(String materia) {
        this.materia = materia;
    }


    public boolean isObrigatoria() {
        return obrigatoria;
    }


    public void setObrigatoria(boolean obrigatoria) {
        this.obrigatoria = obrigatoria;
    }


    public Curso getCurso() {
        return curso;
    }


    public void setCurso(Curso curso) {
        this.curso = curso;
    }



    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    
}


