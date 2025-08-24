package src;

import java.util.List;

public class Professor extends Usuario {
    private String departamento;

    public Professor(String nome, String email, String senha, String departamento) {
        super(nome, email, senha);
        this.departamento = departamento;
    }

    public List<Aluno> listarAlunosDisciplina(Disciplina disciplina) {
        // stub
        return null;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
