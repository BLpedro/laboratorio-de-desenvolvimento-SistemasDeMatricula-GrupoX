package src;


import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {
    private String matricula;
    private List<Matricula> historico;

    public Aluno(String nome, String email, String senha, String matricula) {
        super(nome, email, senha);
        this.matricula = matricula;
        this.historico = new ArrayList<>();
    }

    public void inscreverDisciplina(Disciplina disciplina) {
        // stub
    }

    public void cancelarMatricula(Disciplina disciplina) {
        // stub
    }

    public void consultarDisciplinasMatriculadas() {
        // stub
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<Matricula> getHistorico() {
        return historico;
    }

    public void setHistorico(List<Matricula> historico) {
        this.historico = historico;
    }
}
