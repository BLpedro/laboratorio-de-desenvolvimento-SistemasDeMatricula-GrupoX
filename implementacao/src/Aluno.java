package src;


import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {
    
    private int matricula;
    private List<Disciplina> disciplinas;
    
    public Aluno(int id, String nome, String senha, int matricula) {
        super(id, nome, senha);
        this.matricula = matricula;
        this.disciplinas = new ArrayList<>();
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void matricularDisciplina(Disciplina disciplina){
        //stub
    }

    public void desmatricularDisciplina(Disciplina disciplina){
        //stub
    }

   
}

