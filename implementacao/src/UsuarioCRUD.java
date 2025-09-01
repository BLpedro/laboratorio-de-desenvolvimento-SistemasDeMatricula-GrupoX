package src;

import java.io.*;
import java.util.*;

public class UsuarioCRUD {
    private static final String ARQUIVO = "./implemtentacao/src/usuarios.txt";

    // CREATE
    public void adicionarUsuario(Usuario usuario) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO, true))) {
            writer.write(usuario.toString());
            writer.newLine();
        }
    }

    // READ
    public List<Usuario> listarUsuarios() throws IOException {
        List<Usuario> usuarios = new ArrayList<>();
        File file = new File(ARQUIVO);
        if (!file.exists()) return usuarios;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                usuarios.add(Usuario.fromString(linha));
            }
        }
        return usuarios;
    }

    // UPDATE
    public void atualizarUsuario(int id, String novoNome, String novaSenha) throws IOException {
        List<Usuario> usuarios = listarUsuarios();
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                usuarios.set(usuarios.indexOf(u), new Usuario(novoNome, novaSenha));
                break;
            }
        }
        salvarTodos(usuarios);
    }

    // DELETE
    public void removerUsuario(int id) throws IOException {
        List<Usuario> usuarios = listarUsuarios();
        usuarios.removeIf(u -> u.getId() == id);
        salvarTodos(usuarios);
    }

    // Sobrescreve o arquivo com a lista atualizada
    private void salvarTodos(List<Usuario> usuarios) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Usuario u : usuarios) {
                writer.write(u.toString());
                writer.newLine();
            }
        }
    }
}
