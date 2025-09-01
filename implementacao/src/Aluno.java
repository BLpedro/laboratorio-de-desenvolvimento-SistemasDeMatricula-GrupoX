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

    public void matricularDisciplina(Disciplina disciplina) {
        if (disciplinas.contains(disciplina)) {
            throw new RuntimeException("Aluno já está matriculado nesta disciplina!");
        }
        disciplina.adicionarAluno(this);   
        disciplinas.add(disciplina);       
    }

    public void desmatricularDisciplina(Disciplina disciplina) {
        if (!disciplinas.contains(disciplina)) {
            throw new RuntimeException("Aluno não está matriculado nesta disciplina!");
        }
        disciplina.removerAluno(this);     
        disciplinas.remove(disciplina);    
    }


//-----------------------------------------------

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public List<Disciplina> getDisciplinas() {
        return new ArrayList<>(disciplinas); 
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    
}
