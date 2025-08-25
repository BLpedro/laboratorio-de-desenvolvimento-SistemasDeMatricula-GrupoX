package src;

public abstract class Usuario {
    
    protected String nome;
    protected String senha;
    int id;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public void login(){}
       
    public void cadastrar(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // ...existing code...

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
      
}

