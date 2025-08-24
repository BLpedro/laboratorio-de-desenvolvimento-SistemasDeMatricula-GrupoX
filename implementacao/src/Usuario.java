package src;

public abstract class Usuario {
    
    protected String nome;
    protected String email;
    protected String senha;
    int id;

  public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

       public boolean validarLogin(String senha) {
        return this.senha.equals(senha);
    }

    public void cadastrar(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
