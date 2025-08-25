package src;

import java.util.List;

public class Curriculo {
    
    private String semestre;
    private List<Disciplina> disciplinas;

    public Curriculo(String semestre, List<Disciplina> disciplinas) {
        this.semestre = semestre;
        this.disciplinas = disciplinas;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void definirGrade(){
        //stub
    }

}
