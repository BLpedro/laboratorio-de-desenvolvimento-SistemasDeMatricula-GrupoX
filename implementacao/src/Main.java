package src;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static List<Aluno> alunos;
    private static List<Professor> professores;
    private static List<Disciplina> disciplinas;
    private static List<Curso> cursos;
    private static Secretaria secretaria;

    public static void main(String[] args) {

        // --- CARREGAR DADOS ---
        alunos = ArquivoUtils.carregarAlunos("alunos.txt");
        professores = ArquivoUtils.carregarProfessores("professores.txt");
        disciplinas = ArquivoUtils.carregarDisciplinas("disciplinas.txt", professores, alunos);
        cursos = ArquivoUtils.carregarCursos("cursos.txt", disciplinas);

        secretaria = new Secretaria("Secretaria", "1234");

        boolean sair = false;

        while (!sair) {
            mostrarMenu();
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> abrirPeriodo();
                case 2 -> fecharPeriodo();
                case 3 -> cadastrarAluno();
                case 4 -> cadastrarProfessor();
                case 5 -> cadastrarDisciplina();
                case 6 -> criarCurso();
                case 7 -> matricularAluno();
                case 8 -> desmatricularAluno();
                case 9 -> listarAlunosDisciplina();
                case 10 -> listarDisciplinasCurso();
                case 11 -> encerrarMatricula();
                case 0 -> {
                    sair = true;
                    System.out.println("Saindo do sistema...");
                }
                default -> System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n===== SISTEMA UNIVERSITÁRIO =====");
        System.out.println("1 - Abrir período de matrícula");
        System.out.println("2 - Fechar período de matrícula");
        System.out.println("3 - Cadastrar aluno");
        System.out.println("4 - Cadastrar professor");
        System.out.println("5 - Cadastrar disciplina");
        System.out.println("6 - Criar curso");
        System.out.println("7 - Matricular aluno em disciplina");
        System.out.println("8 - Desmatricular aluno de disciplina");
        System.out.println("9 - Ver alunos matriculados em disciplina (Professor)");
        System.out.println("10 - Listar disciplinas de um curso");
        System.out.println("11 - Encerrar período de matrícula");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void abrirPeriodo() {
        secretaria.abrirMatricula();
        System.out.println("Período de matrícula aberto!");
    }

    private static void fecharPeriodo() {
        secretaria.fecharMatricula();
        System.out.println("Período de matrícula fechado!");
    }

    private static void cadastrarAluno() {
        System.out.print("Nome do aluno: ");
        String nomeAluno = sc.nextLine();
        System.out.print("Senha do aluno: ");
        String senhaAluno = sc.nextLine();
        Aluno aluno = new Aluno(nomeAluno, senhaAluno);
        secretaria.adicionarAluno(aluno, alunos);
        ArquivoUtils.salvarAlunos(alunos, "alunos.txt");
        System.out.println("Aluno cadastrado com sucesso!");
    }

    private static void cadastrarProfessor() {
        System.out.print("Nome do professor: ");
        String nomeProf = sc.nextLine();
        System.out.print("Senha do professor: ");
        String senhaProf = sc.nextLine();
        Professor professor = new Professor(nomeProf, senhaProf);
        secretaria.adicionarProfessor(professor, professores);
        ArquivoUtils.salvarProfessores(professores, "professores.txt");
        System.out.println("Professor cadastrado com sucesso!");
    }

    private static void cadastrarDisciplina() {
        if (professores.isEmpty()) {
            System.out.println("Cadastre um professor antes!");
            return;
        }

        System.out.print("Nome da disciplina: ");
        String nomeDisc = sc.nextLine();
        System.out.print("Código da disciplina: ");
        String codigoDisc = sc.nextLine();
        System.out.print("É obrigatória? (s/n): ");
        boolean obrigatoria = sc.nextLine().equalsIgnoreCase("s");

        System.out.println("Selecione o professor:");
        for (int i = 0; i < professores.size(); i++)
            System.out.println(i + " - " + professores.get(i).getNome());
        int profIndex = sc.nextInt();
        sc.nextLine();

        Professor profSelecionado = professores.get(profIndex);
        Disciplina d = new Disciplina(nomeDisc, codigoDisc, obrigatoria, profSelecionado);
        secretaria.adicionarDisciplina(d, disciplinas);
        ArquivoUtils.salvarDisciplinas(disciplinas, "disciplinas.txt");
        System.out.println("Disciplina cadastrada com sucesso!");
    }

    private static void criarCurso() {
        System.out.print("Nome do curso: ");
        String nomeCurso = sc.nextLine();
        System.out.print("Créditos do curso: ");
        int credito = sc.nextInt();
        sc.nextLine();

        Curso curso = new Curso(nomeCurso, credito);
        cursos.add(curso);
        ArquivoUtils.salvarCursos(cursos, "cursos.txt");
        System.out.println("Curso criado com sucesso!");
    }

    private static void matricularAluno() {
        if (alunos.isEmpty() || disciplinas.isEmpty()) {
            System.out.println("Cadastre alunos e disciplinas antes!");
            return;
        }

        System.out.println("Selecione o aluno:");
        for (int i = 0; i < alunos.size(); i++)
            System.out.println(i + " - " + alunos.get(i).getNome());
        int alunoIndex = sc.nextInt();
        sc.nextLine();

        System.out.println("Selecione a disciplina:");
        for (int i = 0; i < disciplinas.size(); i++)
            System.out.println(i + " - " + disciplinas.get(i).getNome());
        int discIndex = sc.nextInt();
        sc.nextLine();

        try {
            alunos.get(alunoIndex).matricularDisciplina(disciplinas.get(discIndex), secretaria);
            ArquivoUtils.salvarDisciplinas(disciplinas, "disciplinas.txt");
            ArquivoUtils.salvarAlunos(alunos, "alunos.txt");
            System.out.println("Aluno matriculado com sucesso!");
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void desmatricularAluno() {
        if (alunos.isEmpty() || disciplinas.isEmpty()) {
            System.out.println("Cadastre alunos e disciplinas antes!");
            return;
        }

        System.out.println("Selecione o aluno:");
        for (int i = 0; i < alunos.size(); i++)
            System.out.println(i + " - " + alunos.get(i).getNome());
        int alunoDesIndex = sc.nextInt();
        sc.nextLine();

        System.out.println("Selecione a disciplina:");
        for (int i = 0; i < disciplinas.size(); i++)
            System.out.println(i + " - " + disciplinas.get(i).getNome());
        int discDesIndex = sc.nextInt();
        sc.nextLine();

        try {
            alunos.get(alunoDesIndex).desmatricularDisciplina(disciplinas.get(discDesIndex), secretaria);
            ArquivoUtils.salvarDisciplinas(disciplinas, "disciplinas.txt");
            ArquivoUtils.salvarAlunos(alunos, "alunos.txt");
            System.out.println("Aluno desmatriculado com sucesso!");
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void listarAlunosDisciplina() {
        if (professores.isEmpty() || disciplinas.isEmpty()) {
            System.out.println("Cadastre professores e disciplinas antes!");
            return;
        }

        System.out.println("Selecione o professor:");
        for (int i = 0; i < professores.size(); i++)
            System.out.println(i + " - " + professores.get(i).getNome());
        int profVerIndex = sc.nextInt();
        sc.nextLine();

        Professor prof = professores.get(profVerIndex);

        System.out.println("Selecione a disciplina:");
        for (int i = 0; i < disciplinas.size(); i++)
            if (disciplinas.get(i).getProfessor() == prof)
                System.out.println(i + " - " + disciplinas.get(i).getNome());
        int discVerIndex = sc.nextInt();
        sc.nextLine();

        prof.verificarAlunosMatriculados(disciplinas.get(discVerIndex));
    }

    private static void listarDisciplinasCurso() {
        if (cursos.isEmpty()) {
            System.out.println("Cadastre cursos antes!");
            return;
        }

        System.out.println("Selecione o curso:");
        for (int i = 0; i < cursos.size(); i++)
            System.out.println(i + " - " + cursos.get(i).getNome());
        int cursoIndex = sc.nextInt();
        sc.nextLine();

        Curso cSelecionado = cursos.get(cursoIndex);
        System.out.println("Disciplinas do curso " + cSelecionado.getNome() + ":");
        for (Disciplina disc : cSelecionado.getDisciplinas())
            System.out.println("- " + disc.getNome());
    }

    private static void encerrarMatricula() {
        secretaria.encerrarMatriculas(disciplinas);
        ArquivoUtils.salvarDisciplinas(disciplinas, "disciplinas.txt");
        ArquivoUtils.salvarAlunos(alunos, "alunos.txt");
        System.out.println("Período encerrado e disciplinas verificadas!");
    }
}