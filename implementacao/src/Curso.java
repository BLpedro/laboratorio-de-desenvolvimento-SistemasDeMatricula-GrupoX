package src;

import java.util.List;

public class Curso {
    
    private String nome;
    private int credito;
    private List<Curriculo> curriculos;

    public Curso(String nome, int credito, List<Curriculo> curriculos) {
        this.nome = nome;
        this.credito = credito;
        this.curriculos = curriculos;
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

    public List<Curriculo> getCurriculos() {
        return curriculos;
    }

    public void setCurriculos(List<Curriculo> curriculos) {
        this.curriculos = curriculos;
    }

    public void adicionarCurriculo(Curriculo curriculo){
        //stub
    }


}
