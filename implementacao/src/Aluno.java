package src;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {
    
    private List<Disciplina> disciplinas;
    
    public Aluno(String nome, String senha) {
        super(nome, senha);
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


    public List<Disciplina> getDisciplinas() {
        return new ArrayList<>(disciplinas); 
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    
}
