package src;

public abstract class Usuario {
    
    protected String nome;
    protected String senha;
    protected int id;
    protected static int proxMatricula = 0;
    
    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.id = proxMatricula;
        Usuario.proxMatricula++;

    }

    public boolean login(int id, String senha){

        boolean valido = false;

        if(this.id == id && this.senha == senha)
            valido = true;

        return valido;

    }
       
    public void cadastrar(String nome, String senha){     
        
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

