package src;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoUtils {

    // ---------- ALUNOS ----------
    public static void salvarAlunos(List<Aluno> alunos, String arquivo) {
        try (FileWriter fw = new FileWriter(arquivo)) {
            for (Aluno a : alunos) {
                fw.write(a.getId() + ";" + a.getNome() + ";" + a.getSenha() + "\n");
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static List<Aluno> carregarAlunos(String arquivo) {
        List<Aluno> alunos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length >= 3) {
                    int id = Integer.parseInt(partes[0]);
                    String nome = partes[1];
                    String senha = partes[2];
                    Aluno a = new Aluno(id, nome, senha);
                    alunos.add(a);
                }
            }
        } catch (IOException e) { e.printStackTrace(); }
        return alunos;
    }

    // ---------- PROFESSORES ----------
    public static void salvarProfessores(List<Professor> professores, String arquivo) {
        try (FileWriter fw = new FileWriter(arquivo)) {
            for (Professor p : professores) {
                fw.write(p.getId() + ";" + p.getNome() + ";" + p.getSenha() + "\n");
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static List<Professor> carregarProfessores(String arquivo) {
        List<Professor> professores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length >= 3) {
                    int id = Integer.parseInt(partes[0]);
                    String nome = partes[1];
                    String senha = partes[2];
                    Professor p = new Professor(id, nome, senha);
                    professores.add(p);
                }
            }
        } catch (IOException e) { e.printStackTrace(); }
        return professores;
    }

    // ---------- DISCIPLINAS ----------
    public static void salvarDisciplinas(List<Disciplina> disciplinas, String arquivo) {
        try (FileWriter fw = new FileWriter(arquivo)) {
            for (Disciplina d : disciplinas) {
                StringBuilder alunosIds = new StringBuilder();
                for (Aluno a : d.getAlunos()) {
                    alunosIds.append(a.getId()).append(",");
                }
                if (alunosIds.length() > 0) alunosIds.deleteCharAt(alunosIds.length() - 1);
                fw.write(d.getCodigo() + ";" + d.getNome() + ";" + d.isObrigatorio() + ";" +
                        d.getProfessor().getId() + ";" + alunosIds.toString() + "\n");
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static List<Disciplina> carregarDisciplinas(String arquivo, List<Professor> professores, List<Aluno> alunos) {
        List<Disciplina> disciplinas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length >= 4) {
                    String codigo = partes[0];
                    String nome = partes[1];
                    boolean obrigatoria = Boolean.parseBoolean(partes[2]);
                    int idProf = Integer.parseInt(partes[3]);

                    Professor prof = professores.stream().filter(p -> p.getId() == idProf).findFirst().orElse(null);
                    if (prof == null) continue;

                    Disciplina d = new Disciplina(nome, codigo, obrigatoria, prof);

                    // Reconstruir alunos matriculados
                    if (partes.length >= 5 && !partes[4].isEmpty()) {
                        String[] idsAlunos = partes[4].split(",");
                        for (String sId : idsAlunos) {
                            int idAluno = Integer.parseInt(sId);
                            Aluno a = alunos.stream().filter(al -> al.getId() == idAluno).findFirst().orElse(null);
                            if (a != null) {
                                d.adicionarAluno(a);
                                a.getDisciplinas().add(d); // Atualiza lista de disciplinas do aluno
                            }
                        }
                    }

                    disciplinas.add(d);
                }
            }
        } catch (IOException e) { e.printStackTrace(); }
        return disciplinas;
    }

    // ---------- CURSOS ----------
    public static void salvarCursos(List<Curso> cursos, String arquivo) {
        try (FileWriter fw = new FileWriter(arquivo)) {
            for (Curso c : cursos) {
                StringBuilder discCodigos = new StringBuilder();
                for (Disciplina d : c.getDisciplinas()) {
                    discCodigos.append(d.getCodigo()).append(",");
                }
                if (discCodigos.length() > 0) discCodigos.deleteCharAt(discCodigos.length() - 1);
                fw.write(c.getNome() + ";" + c.getCredito() + ";" + discCodigos.toString() + "\n");
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static List<Curso> carregarCursos(String arquivo, List<Disciplina> disciplinas) {
        List<Curso> cursos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length >= 2) {
                    String nome = partes[0];
                    int credito = Integer.parseInt(partes[1]);
                    Curso c = new Curso(nome, credito);

                    if (partes.length >= 3 && !partes[2].isEmpty()) {
                        String[] codDiscs = partes[2].split(",");
                        for (String cod : codDiscs) {
                            Disciplina d = disciplinas.stream().filter(di -> di.getCodigo().equals(cod)).findFirst().orElse(null);
                            if (d != null) c.adicionarDisciplina(d);
                        }
                    }

                    cursos.add(c);
                }
            }
        } catch (IOException e) { e.printStackTrace(); }
        return cursos;
    }
}
