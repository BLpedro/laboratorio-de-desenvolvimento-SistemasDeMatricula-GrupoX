package src;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {

    private List<Disciplina> disciplinas;
    private int obrigatoriasMatriculadas;
    private int optativasMatriculadas;

    private static final int MAX_OBRIGATORIAS = 4;
    private static final int MAX_OPTATIVAS = 2;

    public Aluno(int id, String nome, String senha) {
        super(id, nome, senha);
        this.disciplinas = new ArrayList<>();
        this.obrigatoriasMatriculadas = 0;
        this.optativasMatriculadas = 0;
    }

    public Aluno(String nome, String senha) {
        super(nome, senha);
        this.disciplinas = new ArrayList<>();
        this.obrigatoriasMatriculadas = 0;
        this.optativasMatriculadas = 0;
    }

    public void matricularDisciplina(Disciplina disciplina, Secretaria secretaria) {
        if (!secretaria.isPeriodoMatriculaAberto())
            throw new RuntimeException("Não é possível matricular: período de matrícula fechado!");
        if (disciplinas.contains(disciplina))
            throw new RuntimeException("Aluno já está matriculado nesta disciplina!");
        if (disciplina.isObrigatorio() && obrigatoriasMatriculadas >= MAX_OBRIGATORIAS)
            throw new RuntimeException("Limite de 4 disciplinas obrigatórias já atingido!");
        if (!disciplina.isObrigatorio() && optativasMatriculadas >= MAX_OPTATIVAS)
            throw new RuntimeException("Limite de 2 disciplinas optativas já atingido!");

        disciplina.adicionarAluno(this);
        disciplinas.add(disciplina);

        if (disciplina.isObrigatorio())
            obrigatoriasMatriculadas++;
        else
            optativasMatriculadas++;
    }

    public void desmatricularDisciplina(Disciplina disciplina, Secretaria secretaria) {
        if (!secretaria.isPeriodoMatriculaAberto())
            throw new RuntimeException("Não é possível desmatricular: período de matrícula fechado!");
        if (!disciplinas.contains(disciplina))
            throw new RuntimeException("Aluno não está matriculado nesta disciplina!");

        disciplina.removerAluno(this);
        disciplinas.remove(disciplina);

        if (disciplina.isObrigatorio())
            obrigatoriasMatriculadas--;
        else
            optativasMatriculadas--;
    }

    public List<Disciplina> getDisciplinas() {
        return new ArrayList<>(disciplinas);
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
        obrigatoriasMatriculadas = (int) disciplinas.stream().filter(Disciplina::isObrigatorio).count();
        optativasMatriculadas = disciplinas.size() - obrigatoriasMatriculadas;
    }
}
