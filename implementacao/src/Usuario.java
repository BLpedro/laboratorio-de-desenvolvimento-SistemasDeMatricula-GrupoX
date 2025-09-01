//package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class Usuario {
    private static int contador = 0;

    protected final int id;
    private final String nome;
    private final String senha;

    public Usuario(int id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        if (id > contador) contador = id;
    }

    public Usuario(String nome, String senha) {
        this.id = ++contador;
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

    // Login lendo de um arquivo texto
    public static Usuario login(String arquivo, int id, String senha) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length < 4)
                    continue;

                int idArq = Integer.parseInt(partes[0]);
                String nomeArq = partes[1];
                String senhaArq = partes[2];
                String tipo = partes[3];

                if (idArq == id && senhaArq.equals(senha)) {
                    switch (tipo) {
                        case "Aluno":
                            return new Aluno(nomeArq, senhaArq);
                        case "Professor":
                            return new Professor(nomeArq, senhaArq);
                        case "Secretaria":
                            return new Secretaria(nomeArq, senhaArq);
                        default:
                            return null;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // não encontrou
    }
}
