package src;

import java.util.List;

public class Curso {
    String nome;
    int creditos;
    
    List<Disciplina> disciplinas;

     public Curso(String nome, int creditos, List<Disciplina> disciplinas) {
        this.nome = nome;
        this.creditos = creditos;
        this.disciplinas = disciplinas;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCreditos() {
        return creditos;
    }
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }
    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    } 
    
}
