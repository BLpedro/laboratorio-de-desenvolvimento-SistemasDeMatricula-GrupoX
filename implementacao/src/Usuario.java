package src;

public class Usuario {
    private final int id;
    private final String nome;
    private final String senha;

    public Usuario(int id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

@Override
public String toString() {
    return id + ";" + nome + ";" + senha + ";" + this.getClass().getSimpleName();
}


    public static Usuario fromString(String linha) {
        String[] partes = linha.split(";");
        return new Usuario(
            Integer.parseInt(partes[0]),
            partes[1],
            partes[2]
        );
    }
}
