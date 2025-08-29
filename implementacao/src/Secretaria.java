package src;

import java.util.List;

public class Secretaria extends Usuario{

    private List<Aluno> alunos;
    private List<Professor> professor;
    private List<Disciplina> disciplinas;

    public Secretaria(int id, String nome, String senha, List<Aluno> alunos, List<Professor> professor, List<Disciplina> disciplinas) {
        super(id, nome, senha);
        this.alunos = alunos;
        this.professor = professor;
        this.disciplinas = disciplinas;
    }

    public void gerarCurriculo(Curso curso){
        //stub
    }

    public void manterInformacoes(){
        //stub
    }

    public void adicionarAluno(Aluno aluno){
        //stub
    }

    public void removerAluno(Aluno aluno){
        //stub
    }

    public void adicionarProfessor(Professor professor){
        //stub
    }

    public void removerProfessor(Professor professor){
        //stub
    }
    
    public void adicionarDisciplina(Disciplina disciplina){
        //stub
    }

    public void removerDisciplina(Disciplina disciplina){
        //stub
    }
    
    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Professor> getProfessor() {
        return professor;
    }

    public void setProfessor(List<Professor> professor) {
        this.professor = professor;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

}
