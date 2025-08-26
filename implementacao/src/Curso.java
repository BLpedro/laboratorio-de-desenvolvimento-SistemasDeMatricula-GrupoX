package src;

import java.util.List;

public class Curso {
    
    private String nome;
    private int credito;
    private List<Disciplina> disciplinas;

    public Curso(String nome, int credito, List<Disciplina> disciplinas) {
        this.nome = nome;
        this.credito = credito;
        this.disciplinas = disciplinas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setdisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void adicionardisciplina(Disciplina disciplina){
        //stub
    }


}
