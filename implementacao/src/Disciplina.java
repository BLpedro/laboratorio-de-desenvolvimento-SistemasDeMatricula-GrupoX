package src;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    
    private String nome;
    private String codigo;
    private static final int maxAlunos = 60;
    private static final int minAlunos = 3;
    private boolean obrigatorio;
    private List<Aluno> alunos;

    public Disciplina(String nome, String codigo, boolean obrigatorio) {
        this.nome = nome;
        this.codigo = codigo;
        this.obrigatorio = obrigatorio;
        this.alunos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isObrigatorio() {
        return obrigatorio;
    }

    public void setObrigatorio(boolean obrigatorio) {
        this.obrigatorio = obrigatorio;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public boolean validarDisciplina(){
        //stub
        return true;
    }

    public void adicionarAluno(Aluno aluno){
        //stub
    }

    public void removerAluno(Aluno aluno){
        //stub
    }

    public boolean verificarPeriodo(){
        //stub
        return true;
    }

    
}


