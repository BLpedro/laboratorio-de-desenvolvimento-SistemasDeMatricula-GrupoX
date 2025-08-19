package src;

import java.util.List;

public class Disciplina {

    String Materia;
    boolean obrigatoria;
    Curso curso;
    int qtdAlunos;
    List<Aluno> alunos;

    

    public List<Aluno> getAlunos() {
        return alunos;
    }


    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }


    public String getMateria() {
        return Materia;
    }


    public void setMateria(String materia) {
        Materia = materia;
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


    public int getQtdAlunos() {
        return qtdAlunos;
    }


    public void setQtdAlunos(int qtdAlunos) {
        this.qtdAlunos = qtdAlunos;
    }
    
}


