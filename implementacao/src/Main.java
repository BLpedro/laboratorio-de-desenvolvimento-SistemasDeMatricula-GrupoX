package src;

import java.io.IOException;
import java.util.*;

public class Main {    private static boolean periodoMatriculaAberto = false; // flag simples
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Disciplina> disciplinas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n==== MENU ====");
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Abrir Disciplina");
            System.out.println("3 - Fechar Disciplina");
            System.out.println("4 - Listar Disciplinas");
            System.out.println("5 - Verificar período de matrícula");
            System.out.println("6 - Alternar período de matrícula (abrir/fechar)");
            System.out.println("7 - Matrícular aluno em diciplina (abrir/fechar)");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrarUsuario(sc);
                    break;
                case 2:
                    abrirDisciplina(sc);
                    break;
                case 3:
                    fecharDisciplina(sc);
                    break;
                case 4:
                    listarDisciplinas();
                    break;
                case 5:
                    verificarPeriodoMatricula();
                    break;
                case 6:
                    alternarPeriodoMatricula();
                    break;
                case 7:
                    EntrarEmDisciplina()    ;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }

    // --- FUNÇÕES AUXILIARES ---

private static void cadastrarUsuario(Scanner sc) {
    System.out.println("Tipo de usuário (1=Aluno, 2=Professor, 3=Secretário): ");
    int tipo = sc.nextInt();
    sc.nextLine();

    System.out.print("Nome: ");
    String nome = sc.nextLine();
    System.out.print("Senha: ");
    String senha = sc.nextLine();
    int id = usuarios.size() + 1;
    int matricula = usuarios.size() + 1;
List<Aluno> alunos = new ArrayList<>();
List<Professor> professor = new ArrayList<>();
List<Disciplina> disciplinas = new ArrayList<>();

    Usuario u;
    switch (tipo) {
        case 1:
            u = new Aluno(id, nome, senha, matricula);
            break;
        case 2:
            u = new Professor(id, nome, senha);
            break;
        case 3:
            u = new Secretaria(id, nome, senha, alunos, professor, disciplinas);
            break;
        default:
            u = new Usuario(id, nome, senha);
    }

    usuarios.add(u);

    // salva no arquivo também
    UsuarioCRUD crud = new UsuarioCRUD();
    try {
        crud.adicionarUsuario(u);
    } catch (IOException e) {
        System.out.println("Erro ao salvar usuário no arquivo: " + e.getMessage());
    }

    System.out.println("Usuário cadastrado: " + u.getNome() + " (" + u.getClass().getSimpleName() + ")");
}

   private static void abrirDisciplina(Scanner sc) {
    System.out.print("Nome da disciplina: ");
    String nome = sc.nextLine();

    System.out.print("Código da disciplina: ");
    String codigo = sc.nextLine();

    System.out.print("É obrigatória? (s/n): ");
    boolean obrigatorio = sc.nextLine().equalsIgnoreCase("s");

    System.out.print("Nome do professor responsável: ");
    String nomeProfessor = sc.nextLine();
    Professor professor = new Professor(1, nomeProfessor, "1234"); 
    Disciplina d = new Disciplina(nome, codigo, obrigatorio, professor);
    d.abrir();
    disciplinas.add(d);
    System.out.println("Disciplina aberta: " + d.getNome());
}

    private static void fecharDisciplina(Scanner sc) {
    System.out.print("Nome da disciplina: ");
    String nome = sc.nextLine();
    for (Disciplina d : disciplinas) {
        if (d.getNome().equalsIgnoreCase(nome)) {
            d.fechar();
            System.out.println("Disciplina fechada: " + d.getNome());
            return;
        }
    }
    System.out.println("Disciplina não encontrada.");
}
    private static void listarDisciplinas() {
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return;
        }
        System.out.println("Disciplinas:");
        for (Disciplina d : disciplinas) {
            System.out.println("- " + d);
        }
    }

    private static void verificarPeriodoMatricula() {
        System.out.println("Período de matrícula está " + 
            (periodoMatriculaAberto ? "ABERTO" : "FECHADO"));
    }

    private static void alternarPeriodoMatricula() {
        periodoMatriculaAberto = !periodoMatriculaAberto;
        System.out.println("Período de matrícula agora está " + 
            (periodoMatriculaAberto ? "ABERTO" : "FECHADO"));
    }
}