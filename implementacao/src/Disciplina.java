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

    

    private static final int maxAlunos = 60;
    private static final int minAlunos = 3;

    public Disciplina(String nome, String codigo, boolean obrigatorio,Professor professor) {
        this.nome = nome;
        this.codigo = codigo;
        this.obrigatorio = obrigatorio;
        this.alunos = new ArrayList<>();
        this.professor = professor;
    }

    public boolean validarDisciplina(){

        boolean validada = false;

        if(qtdAlunos > minAlunos)
            validada = true;
        
        return validada;

    }

    public boolean temVaga(){

        boolean temVaga = false;

        if (qtdAlunos < maxAlunos)
            temVaga = true;
        
        return temVaga;

    }

    public void adicionarAluno(Aluno aluno) throws Exception{

        if (temVaga() && verificarPeriodo()){
            alunos.add(aluno);
            qtdAlunos++;
        }else{
            throw new Exception("Não e possivel se matricular!");
        } 

    }

    public void removerAluno(Aluno aluno) throws Exception{

        if(alunos.remove(aluno)){
            qtdAlunos--;
            return;
        }else{
            throw new Exception("Aluno não existe nesta disciplina!");
        }

    }

    public boolean verificarPeriodo(){
        
        boolean permitido = false;

        if (podeMatricular)
            permitido = true;
        
        return permitido;

    }

    //--------------------------------------------------


        public void abrir() {
        this.podeMatricular = true;
    }

    public void fechar() {
        this.podeMatricular = false;
    }

    
    public boolean isPodeMatricular() {
        return podeMatricular;
    }

    public void setPodeMatricular(boolean podeMatricular) {
        this.podeMatricular = podeMatricular;
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

}


