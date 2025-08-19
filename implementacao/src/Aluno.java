package src;

public class Aluno extends Usuario{

    int numMatricula;
    Matricula matricula;
    
    public int getNumMatricula() {
        return numMatricula;
    }
    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }
    public Matricula getMatricula() {
        return matricula;
    }
    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
    
}
